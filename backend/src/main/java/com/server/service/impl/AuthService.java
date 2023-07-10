package com.server.service.impl;

import com.server.dao.interfaces.IAuthDao;
import com.server.dto.AuthDto;
import com.server.service.BaseService;
import com.server.service.interfaces.IAuthService;
import com.server.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends BaseService implements IAuthService {

    @Autowired
    private IAuthDao authDao;

    // TODO: implement
    @Override
    public String login(String username, String password) {
        int userId = authDao.getUserId(username, password);
        if (userId != -1) {
            return JwtUtils.generateToken(username + userId);
        }
        return null;
    }

    @Override
    public AuthDto logout() {
        return null;
    }
}
