package com.server.service.impl;

import com.server.dao.interfaces.IUserDao;
import com.server.dto.UserDto;
import com.server.service.BaseService;
import com.server.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// TODO
public class UserService extends BaseService implements IUserService {

    @Autowired
    private IUserDao userDao;
}
