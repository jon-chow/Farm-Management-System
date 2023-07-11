package com.server.dao.impl;

import com.server.dao.BaseDao;
import com.server.dao.interfaces.ILivestockDao;
import com.server.model.models.livestock.LivestockModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class LivestockDao extends BaseDao implements ILivestockDao {

    //@Autowired
    //PlatformTransactionManager transactionManager;

    @Override
    public List<LivestockModel> getLivestock() {
        return getSqlSession().selectList("com.fms.mapper.LivestockMapper.get-all-livestock");
    }

    @Override
    @Transactional
    public void insertLivestock(LivestockModel livestockModel) {
        getSqlSession().insert("com.fms.mapper.LivestockMapper.insert-livestock", livestockModel);
    }

}
