package com.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import bean.RestResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.enums.ActionType;
import model.enums.AnimalType;
import model.enums.CropType;
import model.models.livestock.LivestockModel;
import model.models.livestock.Livestock_4_Model;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import com.server.service.ILivestockService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
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
    @GetMapping(value = "/")
    public RestResult<LivestockModel> getLivestock(HttpServletRequest req, HttpServletResponse res) throws IOException {
        JSONArray livestock = system.getLivestock(req);

        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(livestock);
        out.flush();

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());
    }

    /**
     * Handles Filtering Livestock By: harvestable, animalType, min Age, max Age, diet, min tagID, max tagID,
     * minWaterSpent, minFoodSpent
     * <p>
     * POST /api/livestock/filteredValues
     */
    @PostMapping(value = "/filteredValues")
    @ResponseBody
    public RestResult<LivestockModel> getFilteredLivestock(@RequestBody Map<String, Object> map, HttpServletResponse res) throws IOException {
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

        JSONArray livestock = system.getFilteredLivestock(harvestable, animalType, diet, minAge, maxAge,
                minTagID, maxTagID, minWaterSpent, minFoodSpent);
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(livestock);
        out.flush();

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());
    }

    /**
     * Handles Insert Livestock Requests
     * <p>
     * POST /api/livestock
     */
    @PostMapping(value = "/")
    public RestResult<LivestockModel> insertLiveStock(@RequestBody Map<String, Object> map) {
        LivestockModel model = LivestockModel.fromJSON(new JSONObject(map));

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());
        // return system.insertLivestock(model);
    }

    /**
     * Handles Delete Livestock Requests
     * <p>
     * DELETE /api/livestock
     */
    @DeleteMapping(value = "/")
    @ResponseBody
    public RestResult<LivestockModel> deleteLivestock(@RequestBody Map<String, Object> map) {
        int tagIDToDelete = (int) map.get("tagID");

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());

        // return system.deleteLivestock(tagIDToDelete);
    }

    /**
     * Handles Update Livestock Requests
     * <p>
     * PATCH /api/livestock
     */
    @PatchMapping(value = "/")
    @ResponseBody
    public RestResult<LivestockModel> updateLivestock(@RequestBody Map<String, Object> map) {
        Livestock_4_Model model = Livestock_4_Model.fromJSON(new JSONObject(map.get("livestock").toString()));
        ActionType actionType = ActionType.valueOf(map.get("actionType").toString().toUpperCase());

        // TODO: replace stub.
        return RestResult.success(stubLivestockModel());

        // return system.updateLivestock(model, actionType);
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
        JSONArray data = system.getWaterAndFoodOfLivestock(tagID);

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
