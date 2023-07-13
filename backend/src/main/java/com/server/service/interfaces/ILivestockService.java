package com.server.service.interfaces;

import com.server.dto.LivestockDto;
import jakarta.servlet.http.HttpServletRequest;
import com.server.model.enums.ActionType;
import com.server.model.enums.AnimalType;
import com.server.model.enums.CropType;
import com.server.model.models.livestock.LivestockModel;
import com.server.model.models.livestock.Livestock_4_Model;
import org.json.JSONArray;

import java.util.List;


public interface ILivestockService {
    public List<LivestockDto> getLivestock();

    public List<LivestockDto> getFilteredLivestock(String harvestable, AnimalType animalType, CropType diet, int minAge, int maxAge,
                                          int minTagID, int maxTagID, int minWaterSpent, int minFoodSpent);

    public List<LivestockDto> getWaterAndFoodOfLivestock(int tagID);

    public LivestockDto deleteLivestock(int tagID);

    /**
     * Insert a livestock given info
     */
    public LivestockDto insertLivestock(LivestockModel model);

    /**
     * Update a livestock with given info
     */

    public LivestockDto updateLivestock(Livestock_4_Model model, ActionType actionType);
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
