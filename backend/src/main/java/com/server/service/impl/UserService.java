package com.server.service.impl;

import com.server.dao.interfaces.IUserDao;
import com.server.dto.UserDto;
import com.server.service.BaseService;
import com.server.service.interfaces.IUserService;
import com.server.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService implements IUserService {

    @Autowired
    private IUserDao userDao;

    // TODO: implement
    @Override
    public String login(String username, String password) {
        int userId = userDao.getUserId(username, password);
        if (userId != -1) {
            return JwtUtils.generateToken("" + 1);
        }
        return null;
    }

    @Override
    public UserDto logout() {
        return null;
    }
}
