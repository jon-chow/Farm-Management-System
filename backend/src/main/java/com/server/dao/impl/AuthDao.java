package com.server.dao.impl;

import com.server.dao.BaseDao;
import com.server.dao.interfaces.IAuthDao;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
// TODO: implement
public class AuthDao extends BaseDao implements IAuthDao {

    @Override
    public boolean doesAccountExist(String username, String password) {
        //
        return false;
    }

    @Override
    public int getUserId(String username, String password) {
        Map<String, String> map = Map.of("username", username, "password", password);
        return getSqlSession().selectOne("com.fms.mapper.UserMapper.get-user-id", map);
    }
 }
