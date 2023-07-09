package com.server.dao.impl;

import com.server.dao.BaseDao;
import com.server.dao.interfaces.IUserDao;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends BaseDao implements IUserDao {

    @Override
    public boolean doesAccountExist(String username, String password) {
        //
        return false;
    }

    @Override
    public int getUserId(String username, String password) {
        return -1;
    }
 }
