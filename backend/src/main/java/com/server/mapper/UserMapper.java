package com.server.mapper;

import com.server.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserModel> getAllUser();
    UserModel getUser(@Param("userID") int userID);
    void insertUser(@Param("user") UserModel userModel);
    void updateUser(@Param("user") UserModel userModel, @Param("userID") int userID);
    void patchUser(@Param("user") UserModel userModel, @Param("userID") int userID);
    void deleteUser(@Param("userID") int userID);
}
