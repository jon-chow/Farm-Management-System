package com.server.service;

import dao.ILivestockDao;
import database.DatabaseConnectionHandler;
import dto.LivestockDto;
import jakarta.servlet.http.HttpServletRequest;
import model.enums.ActionType;
import model.enums.AnimalType;
import model.enums.CropType;
import model.filters.LivestockFilterModel;
import model.models.livestock.LivestockModel;
import model.models.livestock.Livestock_4_Model;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivestockService extends BaseService implements ILivestockService {

    // TODO: remove this and refactor class.
    private DatabaseConnectionHandler dbHandler = null;

    // TODO: modify config file to autowire transaction manager.
    // @Autowired
    PlatformTransactionManager transactionManager;

//    @Autowired
    private ILivestockDao livestockDao;

    /**
     * Retrieves all livestock data from database
     */
    @Transactional
    public List<LivestockDto> getLivestock() {
        List<LivestockModel> livestockList = livestockDao.getLivestock();

        // TODO: convert from model to dto
        return null;
        // return livestockList;
    }

    public List<LivestockDto> getLivestock(HttpServletRequest req) {
        ArrayList<JSONObject> livestock = dbHandler.getLivestock();
        JSONArray livestockArray = new JSONArray(livestock);

        // TODO: convert from model to dto
        return null;
        // return livestockArray;
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

    public LivestockDto deleteLivestock(int tagID) {
        // TODO: convert from model to dto
        return null;
        // return dbHandler.deleteLivestock(tagID);
    }

    /**
     * Insert a livestock given info
     */
    public LivestockDto insertLivestock(LivestockModel model) {
        // TODO: convert from model to dto
        return null;
        // return dbHandler.insertLivestock(model);
    }

    /**
     * Update a livestock with given info
     */

    public LivestockDto updateLivestock(Livestock_4_Model model, ActionType actionType) {
        // TODO: convert from model to dto
        return null;
        // return dbHandler.updateLivestock(model, actionType);
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
