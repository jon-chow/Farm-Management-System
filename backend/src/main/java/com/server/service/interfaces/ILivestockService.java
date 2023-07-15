package com.server.service.interfaces;

import com.server.dto.LivestockDto;
import com.server.model.enums.AnimalType;
import com.server.model.enums.CropType;
import org.json.JSONArray;

import java.util.List;


public interface ILivestockService {

    /**
     * Get list of all livestock
     * @return
     */
    public List<LivestockDto> getLivestock();

    /**
     * Get livestock with specific tagID
     */
    public LivestockDto getLivestock(int tagID);

    /**
     * Update the livestock based on tagID.
     * @param livestockDto
     * @return
     */
    public LivestockDto updateLivestock(LivestockDto livestockDto, int tagID);

    public LivestockDto patchLivestock(LivestockDto livestockDto, int tagID);

    /**
     * Insert a livestock given info
     */
    public LivestockDto insertLivestock(LivestockDto livestockDto);

    public List<LivestockDto> getWaterAndFoodOfLivestock(int tagID);

    public void deleteLivestock(int tagID);




    /**
     * OLD STUFF/METHODS
     */

    /**
     * Join query with vet records
     */
    public JSONArray getVetRecords(int id);

    /**
     * Aggregation with group by -> count animal types
     */
    public JSONArray getAnimalCountType();

    public JSONArray getAnimalCountTypeByAge(int age);

    public List<LivestockDto> getFilteredLivestock(String harvestable, AnimalType animalType, CropType diet, int minAge, int maxAge,
                                                   int minTagID, int maxTagID, int minWaterSpent, int minFoodSpent);


}
