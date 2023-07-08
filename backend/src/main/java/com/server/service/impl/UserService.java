package com.server.service.impl;

import com.server.dto.UserDto;
import com.server.service.BaseService;
import com.server.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService implements IUserService {

    // TODO: implement
    @Override
    public UserDto login(String username, String password) {
        return null;
    }

    @Override
    public UserDto logout() {
        return null;
    }
}
