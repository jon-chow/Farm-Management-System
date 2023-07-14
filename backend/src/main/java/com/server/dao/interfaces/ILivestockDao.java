package com.server.dao.interfaces;

import com.server.model.models.livestock.LivestockModel;

import java.util.List;

public interface ILivestockDao {
    public List<LivestockModel> getLivestock();
    public void insertLivestock(LivestockModel livestockModel);
    public void updateLivestock(LivestockModel livestockModel, int tagID);
    public void deleteLivestock(int tagID);
}
