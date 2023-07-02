package com.server.service;

import database.DatabaseConnectionHandler;
import jakarta.servlet.http.HttpServletRequest;
import model.enums.ActionType;
import model.enums.AnimalType;
import model.enums.CropType;
import model.filters.LivestockFilterModel;
import model.models.livestock.LivestockModel;
import model.models.livestock.Livestock_4_Model;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LivestockService extends BaseService implements ILivestockService {

    // TODO: remove this and refactor class.
    private DatabaseConnectionHandler dbHandler = null;

    /**
     * Retrieves all livestock data from database
     */
    public JSONArray getLivestock() {
        ArrayList<JSONObject> livestock = dbHandler.getLivestock();
        JSONArray livestockArray = new JSONArray(livestock);
        return livestockArray;
    }

    public JSONArray getLivestock(HttpServletRequest req) {
        ArrayList<JSONObject> livestock = dbHandler.getLivestock();
        JSONArray livestockArray = new JSONArray(livestock);
        return livestockArray;
    }

    public JSONArray getFilteredLivestock(String harvestable, AnimalType animalType, CropType diet, int minAge, int maxAge,
                                          int minTagID, int maxTagID, int minWaterSpent, int minFoodSpent) {
        LivestockFilterModel model = new LivestockFilterModel(harvestable, animalType, diet, minAge, maxAge,
                minTagID, maxTagID, minWaterSpent, minFoodSpent);

        ArrayList<JSONObject> livestock = dbHandler.getFilteredLivestock(model);
        JSONArray livestockArray = new JSONArray(livestock);
        return livestockArray;
    }

    public JSONArray getWaterAndFoodOfLivestock(int tagID) {
        ArrayList<JSONObject> data = dbHandler.getWaterAndFoodSpentOfLivestock(tagID);
        JSONArray dataArray = new JSONArray(data);
        return dataArray;
    }

    public boolean deleteLivestock(int tagID) {
        return dbHandler.deleteLivestock(tagID);
    }

    /**
     * Insert a livestock given info
     */
    public boolean insertLivestock(LivestockModel model) {
        return dbHandler.insertLivestock(model);
    }

    /**
     * Update a livestock with given info
     */

    public boolean updateLivestock(Livestock_4_Model model, ActionType actionType) {
        return dbHandler.updateLivestock(model, actionType);
    }

    /**
     * Join query with vet records
     */
    public JSONArray getVetRecords(int id) {
        ArrayList<JSONObject> data = dbHandler.findLivestockHealthStatus(id);
        JSONArray dataArray = new JSONArray(data);
        return dataArray;
    }

    /**
     * Aggregation with group by -> count animal types
     */
    public JSONArray getAnimalCountType() {
        ArrayList<JSONObject> data = dbHandler.findCountedTypesSold();
        JSONArray dataArray = new JSONArray(data);
        return dataArray;
    }

    public JSONArray getAnimalCountTypeByAge(int age) {
        ArrayList<JSONObject> data = dbHandler.findCountedTypesSoldByAge(age);
        JSONArray dataArray = new JSONArray(data);
        return dataArray;
    }
}
