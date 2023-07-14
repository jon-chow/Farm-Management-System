package com.server.service.impl;

import com.server.dao.interfaces.IUserDao;
import com.server.dto.UserDto;
import com.server.model.UserModel;
import com.server.service.BaseService;
import com.server.service.interfaces.IUserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService implements IUserService {

    @Autowired
    private IUserDao userDao;

    public List<UserDto> getAllUser() {
        List<UserModel> userList = userDao.getAllUser();
        return toDto(userList);
    }

    public UserDto getUser(int userID) {
        UserModel user = userDao.getUser(userID);
        return toDto(user);
    }

    public UserDto insertUser(UserDto userDto) {
        UserModel userModel = toModel(userDto);
        userDao.insertUser(userModel);
        return userDto;
    }

    public UserDto updateUser(UserDto userDto, int userID) {
        UserModel userModel = toModel(userDto);
        userDao.updateUser(userModel, userID);
        return userDto;
    }

    public UserDto patchUser(UserDto userDto, int userID) {
        return null;
    }

    public void deleteUser(int userID) {
        userDao.deleteUser(userID);
    }

    /**
     * Convert a user model to a user data transfer object.
     * @param userModel
     * @return The user data transfer object.
     */
    private UserDto toDto(final UserModel userModel) {
        return UserDto.builder()
                .userID(userModel.getUserID())
                .username(userModel.getUsername())
                .password(userModel.getPassword())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .roles(userModel.getRoles())
                .lastLogin(userModel.getLastLogin())
                .build();
    }

    /**
     * Convert a list of user models to a list of user data transfer objects.
     * @param userModels The list of user models.
     * @return The list of user data transfer objects.
     */
    private List<UserDto> toDto(final List<UserModel> userModels) {
        List<UserDto> userDtos = new ArrayList<>();
        for (UserModel userModel : userModels) {
            userDtos.add(toDto(userModel));
        }
        return userDtos;
    }

    /**
     * Convert a user data transfer object to a user model.
     * @param userDto The user data transfer object.
     * @return The user model.
     */
    private UserModel toModel(final UserDto userDto) {
        return UserModel.builder()
                .userID(userDto.getUserID())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .roles(userDto.getRoles())
                .lastLogin(userDto.getLastLogin())
                .build();
    }
}
