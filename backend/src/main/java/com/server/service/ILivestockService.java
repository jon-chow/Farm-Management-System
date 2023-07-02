package com.server.service;

import jakarta.servlet.http.HttpServletRequest;
import model.enums.ActionType;
import model.enums.AnimalType;
import model.enums.CropType;
import model.filters.LivestockFilterModel;
import model.models.livestock.LivestockModel;
import model.models.livestock.Livestock_4_Model;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public interface ILivestockService {
    public JSONArray getLivestock();

    public JSONArray getLivestock(HttpServletRequest req);

    public JSONArray getFilteredLivestock(String harvestable, AnimalType animalType, CropType diet, int minAge, int maxAge,
                                          int minTagID, int maxTagID, int minWaterSpent, int minFoodSpent);

    public JSONArray getWaterAndFoodOfLivestock(int tagID);

    public boolean deleteLivestock(int tagID);

    /**
     * Insert a livestock given info
     */
    public boolean insertLivestock(LivestockModel model);

    /**
     * Update a livestock with given info
     */

    public boolean updateLivestock(Livestock_4_Model model, ActionType actionType);
    /**
     * Join query with vet records
     */

    public JSONArray getVetRecords(int id);

    /**
     * Aggregation with group by -> count animal types
     */
    public JSONArray getAnimalCountType();

    public JSONArray getAnimalCountTypeByAge(int age);

}
