package com.server.dao.interfaces;

import com.server.model.models.livestock.LivestockModel;

import java.util.List;

public interface ILivestockDao {
    public List<LivestockModel> getLivestock();
}
