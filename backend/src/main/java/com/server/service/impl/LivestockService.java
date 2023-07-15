package com.server.service.impl;

import com.server.dao.interfaces.ILivestockDao;
import com.server.database.DatabaseConnectionHandler;
import com.server.dto.LivestockDto;
import com.server.model.enums.AnimalType;
import com.server.model.enums.CropType;
import com.server.model.filters.LivestockFilterModel;
import com.server.model.models.livestock.LivestockModel;
import com.server.service.BaseService;
import com.server.service.interfaces.ILivestockService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivestockService extends BaseService implements ILivestockService {

    // TODO: remove this and refactor class.
    private DatabaseConnectionHandler dbHandler = null;

    // TODO: modify config file to autowire transaction manager.
    // @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    private ILivestockDao livestockDao;

    /**
     * Retrieves all livestock data from database
     */
    @Override
    public List<LivestockDto> getLivestock() {
        List<LivestockModel> livestockList = livestockDao.getLivestock();
        return toDto(livestockList);
    }

    /**
     * Retrieves livestock with given tagID
     */
    public LivestockDto getLivestock(int tagID){
        LivestockModel livestockModel = livestockDao.getLivestock(tagID);
        return toDto(livestockModel);
    }

    /**
     * Insert a livestock given info
     */
    public LivestockDto insertLivestock(LivestockDto livestockDto) {
        LivestockModel livestockModel = toModel(livestockDto);
        livestockDao.insertLivestock(livestockModel);
        return livestockDto;
    }

    @Override
    public LivestockDto updateLivestock(LivestockDto livestockDto, int tagID) {
        LivestockModel livestockModel = toModel(livestockDto);
        livestockDao.updateLivestock(livestockModel, tagID);
        return livestockDto;
    }

    @Override
    public LivestockDto patchLivestock(LivestockDto livestockDto, int tagID) {
        return null;
    }

    public void deleteLivestock(int tagID) {
        livestockDao.deleteLivestock(tagID);
    }

    private LivestockDto toDto(final LivestockModel livestockModel) {
        return LivestockDto.builder()
                .tagID(livestockModel.getTagID())
                .animalType(livestockModel.getAnimalType())
                .age(livestockModel.getAge())
                .diet(livestockModel.getDiet())
                .weight(livestockModel.getWeight())
                .lastFed(livestockModel.getLastFed())
                .harvestable(livestockModel.isHarvestable())
                .lastViolatedForHarvestedGoods(livestockModel.getLastViolatedForHarvestedGoods())
                .build();
    }

    private List<LivestockDto> toDto(final List<LivestockModel> livestockModels) {
        List<LivestockDto> livestockDtos = new ArrayList<>();
        for (LivestockModel livestockModel : livestockModels) {
            livestockDtos.add(toDto(livestockModel));
        }
        return livestockDtos;
    }

    private LivestockModel toModel(final LivestockDto livestockDto) {
        return LivestockModel.builder()
                .tagID(livestockDto.getTagID())
                .animalType(livestockDto.getAnimalType())
                .age(livestockDto.getAge())
                .diet(livestockDto.getDiet())
                .weight(livestockDto.getWeight())
                .lastFed(livestockDto.getLastFed())
                .harvestable(livestockDto.isHarvestable())
                .lastViolatedForHarvestedGoods(livestockDto.getLastViolatedForHarvestedGoods())
                .build();
    }


    /**
     * OLD STUFF/METHODS
     */

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

    public List<LivestockDto> getFilteredLivestock(String harvestable, AnimalType animalType, CropType diet, int minAge, int maxAge,
                                                   int minTagID, int maxTagID, int minWaterSpent, int minFoodSpent) {
        LivestockFilterModel model = new LivestockFilterModel(harvestable, animalType, diet, minAge, maxAge,
                minTagID, maxTagID, minWaterSpent, minFoodSpent);

        ArrayList<JSONObject> livestock = dbHandler.getFilteredLivestock(model);
        JSONArray livestockArray = new JSONArray(livestock);

        // TODO: convert from model to dto
        return null;

        //return livestockArray;
    }

    public List<LivestockDto> getWaterAndFoodOfLivestock(int tagID) {
        ArrayList<JSONObject> data = dbHandler.getWaterAndFoodSpentOfLivestock(tagID);
        JSONArray dataArray = new JSONArray(data);

        // TODO: convert from model to dto
        return null;
        //return dataArray;
    }
}
