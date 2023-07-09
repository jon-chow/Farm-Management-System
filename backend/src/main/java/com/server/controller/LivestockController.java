package com.server.controller;

import com.server.dto.LivestockDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.server.bean.RestResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.server.model.enums.ActionType;
import com.server.model.enums.AnimalType;
import com.server.model.enums.CropType;
import com.server.model.models.livestock.LivestockModel;
import com.server.model.models.livestock.Livestock_4_Model;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.server.service.interfaces.ILivestockService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/livestock")
public class LivestockController {

    // TODO: refactor to use something like 'LivestockService'
    @Autowired
    private ILivestockService system;

    /* -------------------------------------------------------------------------- */
    /*                             LIVESTOCK REQUESTS                             */
    /* -------------------------------------------------------------------------- */

    /**
     * Handles Retrieving Livestock Requests
     * GET /api/livestock
     */
    @GetMapping(value = "")
    public RestResult<List<LivestockDto>> getLivestock(HttpServletRequest req, HttpServletResponse res) throws IOException {
        System.out.println("Getting Livestock!");
        List<LivestockDto> livestock = system.getLivestock(req);
        return RestResult.success(livestock);
    }

    /**
     * Handles Filtering Livestock By: harvestable, animalType, min Age, max Age, diet, min tagID, max tagID,
     * minWaterSpent, minFoodSpent
     * <p>
     * POST /api/livestock/filteredValues
     */
    @PostMapping(value = "/filteredValues")
    @ResponseBody
    public RestResult<List<LivestockDto>> getFilteredLivestock(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
        // Check for if null for these values.
        String harvestable = map.get("harvestable").toString().toUpperCase();
        AnimalType animalType = AnimalType.valueOf(map.get("animalType").toString().toUpperCase());
        CropType diet = CropType.valueOf(map.get("diet").toString().toUpperCase());

        Map<String, Object> tagID = (Map<String, Object>) map.get("tagID");
        int minTagID = (int) tagID.get("min");
        int maxTagID = (int) tagID.get("max");

        Map<String, Object> age = (Map<String, Object>) map.get("age");
        int minAge = (int) age.get("min");
        int maxAge = (int) age.get("max");

        int minWaterSpent = (int) map.get("minWaterSpent");
        int minFoodSpent = (int) map.get("minFoodSpent");

        List<LivestockDto> livestock = system.getFilteredLivestock(harvestable, animalType, diet, minAge, maxAge,
                minTagID, maxTagID, minWaterSpent, minFoodSpent);
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(livestock);
        out.flush();

        // TODO: replace stub.
        return RestResult.success(livestock);
    }

    /**
     * Handles Insert Livestock Requests
     * <p>
     * POST /api/livestock
     */
    @PostMapping(value = "")
    public RestResult<LivestockDto> insertLiveStock(@RequestBody Map<String, Object> map) {
        LivestockModel livestock = LivestockModel.fromJSON(new JSONObject(map));
        LivestockDto livestockDto = system.insertLivestock(livestock);
        return RestResult.success(livestockDto);
    }

    /**
     * Handles Delete Livestock Requests
     * <p>
     * DELETE /api/livestock
     */
    @DeleteMapping(value = "")
    @ResponseBody
    public RestResult<LivestockDto> deleteLivestock(@RequestBody Map<String, Object> map) {
        int tagIDToDelete = (int) map.get("tagID");
        LivestockDto deletedLivestock = system.deleteLivestock(tagIDToDelete);
        return RestResult.success(deletedLivestock);
    }

    /**
     * Handles Update Livestock Requests
     * <p>
     * PATCH /api/livestock
     */
    @PatchMapping(value = "")
    @ResponseBody
    public RestResult<LivestockDto> updateLivestock(@RequestBody Map<String, Object> map) {
        Livestock_4_Model model = Livestock_4_Model.fromJSON(new JSONObject(map.get("livestock").toString()));
        ActionType actionType = ActionType.valueOf(map.get("actionType").toString().toUpperCase());
        LivestockDto updatedLivestock = system.updateLivestock(model, actionType);
        return RestResult.success(updatedLivestock);
    }


    /**
     * Handles getVetRecords request for the livestock
     * <p>
     * GET /api/livestock/vetRecords
     */
    @GetMapping(value = "/vetRecords")
    public RestResult<LivestockModel> getVetRecords(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
        int tag_to_find = Integer.parseInt(map.get("tagID").toString());
        JSONArray livestock = system.getVetRecords(tag_to_find);

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(livestock);
        out.flush();

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());
    }

    /**
     * Gets the total food and water spent for a given livestock (tagID)
     * <p>
     * GET /api/livestock/foodWaterSpent
     */
    @GetMapping(value = "/foodWaterSpent")
    public RestResult<LivestockModel> getFoodWaterSpent(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
        int tagID = Integer.parseInt(map.get("tagID").toString());
        List<LivestockDto> data = system.getWaterAndFoodOfLivestock(tagID);

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(data);
        out.flush();

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());
    }


    /**
     * Gets the animal count for each animal type
     * <p>
     * GET /api/livestock/count
     */
    @GetMapping(value = "/count")
    public RestResult<LivestockModel> getAnimalCountType(HttpServletResponse res) throws IOException {
        JSONArray livestock = system.getAnimalCountType();

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(livestock);
        out.flush();

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());
    }

    /**
     * Gets the animal count for each animal type filtered by age
     * <p>
     * GET /api/livestock/animalCountByAge
     */
    @GetMapping(value = "/animalCountByAge")
    public RestResult<LivestockModel> getAnimalCountTypeByAge(@RequestParam(name = "age") String age, HttpServletResponse res) throws IOException {
        JSONArray livestock = system.getAnimalCountTypeByAge(Integer.valueOf(age));

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(livestock);
        out.flush();

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());
    }

    private LivestockModel stubLivestockModel() {
        return new LivestockModel(-1, AnimalType.PIG, -1, CropType.WHEAT, 10,
                null, false, null);
    }

}
