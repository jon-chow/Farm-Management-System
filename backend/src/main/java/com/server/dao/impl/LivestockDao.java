package com.server.dao.impl;

import com.server.dao.BaseDao;
import com.server.dao.interfaces.ILivestockDao;
import com.server.mapper.LivestockMapper;
import com.server.model.models.livestock.LivestockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class LivestockDao extends BaseDao implements ILivestockDao {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    LivestockMapper livestockMapper;

    @Override
    public List<LivestockModel> getLivestock() {
        return livestockMapper.getAllLivestock();
    }

    @Override
    @Transactional
    public void insertLivestock(LivestockModel livestockModel) {
        livestockMapper.insertLivestock(livestockModel);
    }

    @Override
    @Transactional
    public void updateLivestock(LivestockModel livestockModel, int tagID) {
        livestockMapper.updateLivestock(livestockModel, tagID);
    }

    @Override
    @Transactional
    public void deleteLivestock(int tagID) {
        livestockMapper.deleteLivestock(tagID);
    }

}
