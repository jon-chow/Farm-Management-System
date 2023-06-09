package com.server.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.server.dto.LivestockDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.server.bean.RestResult;
import jakarta.servlet.http.HttpServletResponse;
import com.server.model.enums.AnimalType;
import com.server.model.enums.CropType;
import com.server.model.models.livestock.LivestockModel;
import org.json.JSONArray;
import org.springframework.web.bind.annotation.*;
import com.server.service.interfaces.ILivestockService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/livestock")
public class LivestockController {
    @Autowired
    private ILivestockService system;

    private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
            .create();

    /* -------------------------------------------------------------------------- */
    /*                             LIVESTOCK REQUESTS                             */
    /* -------------------------------------------------------------------------- */

    /**
     * Handles Retrieving Livestock Requests
     * GET /api/v1/livestock
     */
    @GetMapping(value = "")
    public RestResult<List<LivestockDto>> getLivestock() {
        List<LivestockDto> livestock = system.getLivestock();
        return RestResult.success(livestock);
    }

    /**
     * Handles Retrieving Livestock Requests
     * GET /api/v1/livestock/{tagID}
     */
    @GetMapping(value = "/{tagID}")
    public RestResult<LivestockDto> getLivestock(@PathVariable("tagID") int tagID) {
        LivestockDto livestock = system.getLivestock(tagID);
        return RestResult.success(livestock);
    }

    /**
     * Handles Insert Livestock Requests
     * <p>
     * POST /api/v1/livestock
     */
    @PostMapping(value = "")
    public RestResult<LivestockDto> insertLiveStock(@RequestBody String jsonPayload) {
        LivestockDto livestockDto = gson.fromJson(jsonPayload, LivestockDto.class);
        LivestockDto insertedLivestockDto = system.insertLivestock(livestockDto);
        return RestResult.success(insertedLivestockDto);
    }

    /**
     * Handles Update Livestock Requests
     * <p>
     * PUT /api/v1/livestock/{tagID}
     */
    @PutMapping(value = "/{tagID}")
    @ResponseBody
    public RestResult<LivestockDto> updateLivestock(@RequestBody String jsonPayload, @PathVariable("tagID") int tagID) {
        // TODO: validate that all fields are present in jsonPayload
        LivestockDto livestockDto = gson.fromJson(jsonPayload, LivestockDto.class);
        system.updateLivestock(livestockDto, tagID);
        return RestResult.success(livestockDto);
    }

    /**
     * Handles Partially Updating Livestock Requests
     * <p>
     * PATCH /api/v1/livestock/{tagID}
     */
    @PatchMapping(value = "/{tagIID}")
    public RestResult<LivestockDto> patchLivestock(@RequestBody String jsonPayload, @PathVariable("tagID") int tagID) {
        // TODO: implement
        return null;
    }

    /**
     * Handles Delete Livestock Requests
     * <p>
     * DELETE /api/v1/livestock/{tagID}
     */
    @DeleteMapping(value = "/{tagID}")
    @ResponseBody
    public RestResult<LivestockDto> deleteLivestock(@PathVariable("tagID") int tagID) {
        system.deleteLivestock(tagID);
        return RestResult.success(null);
    }

    private LivestockModel stubLivestockModel() {
        return new LivestockModel(-1, AnimalType.PIG, -1, CropType.WHEAT, 10,
                null, false, null);
    }

    /**
     * OLD STUFF/METHODS
     */

    /**
     * Handles Filtering Livestock By: harvestable, animalType, min Age, max Age, diet, min tagID, max tagID,
     * minWaterSpent, minFoodSpent
     * <p>
     * POST /api/v1/livestock/filteredValues
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
     * Gets the animal count for each animal type filtered by age
     * <p>
     * GET /api/v1/livestock/animalCountByAge
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

    /**
     * Gets the animal count for each animal type
     * <p>
     * GET /api/v1/livestock/count
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
     * Handles getVetRecords request for the livestock
     * <p>
     * GET /api/v1/livestock/vetRecords
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
     * GET /api/v1/livestock/foodWaterSpent
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


}
