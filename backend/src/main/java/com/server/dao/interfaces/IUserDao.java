package com.server.dao.interfaces;

import com.server.model.UserModel;

import java.util.List;

public interface IUserDao {
    public List<UserModel> getAllUser();
    public UserModel getUser(int userID);
    public void insertUser(UserModel userModel);
    public void updateUser(UserModel userModel, int userID);
    public void patchUser(UserModel userModel, int userID);
    public void deleteUser(int userID);
}
