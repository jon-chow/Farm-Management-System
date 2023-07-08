package com.server.dao.impl;

import com.server.dao.BaseDao;
import com.server.dao.interfaces.ILivestockDao;
import com.server.model.models.livestock.LivestockModel;

import java.util.List;

public class LivestockDao extends BaseDao implements ILivestockDao {
//    @Autowired
//    PlatformTransactionManager transactionManager;

    @Override
    public List<LivestockModel> getLivestock() {
        return getSqlSession().selectList("com.fms.mapper.LivestockMapper.get-all-livestock");
    }

}
