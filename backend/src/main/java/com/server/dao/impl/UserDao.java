package com.server.dao.impl;

import com.server.dao.BaseDao;
import com.server.dao.interfaces.IUserDao;
import com.server.mapper.UserMapper;
import com.server.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserDao extends BaseDao implements IUserDao {
	
    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserModel> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public UserModel getUser(int userID) {
        return userMapper.getUser(userID);
    }

    @Override
    @Transactional
    public void insertUser(UserModel userModel) {
        userMapper.insertUser(userModel);
    }

    @Override
    @Transactional
    public void updateUser(UserModel userModel, int userID) {
        userMapper.updateUser(userModel, userID);
    }

    @Override
    @Transactional
    public void patchUser(UserModel userModel, int userID) {
        userMapper.patchUser(userModel, userID);
    }

    @Override
    @Transactional
    public void deleteUser(int userID) {
        userMapper.deleteUser(userID);
    }
}
