package dao;

import model.models.livestock.LivestockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

public class LivestockDao extends BaseDao implements ILivestockDao {
//    @Autowired
//    PlatformTransactionManager transactionManager;

    @Override
    public List<LivestockModel> getLivestock() {
        return getSqlSession().selectList("com.fms.mapper.LivestockMapper.get-all-livestock");
    }

}
