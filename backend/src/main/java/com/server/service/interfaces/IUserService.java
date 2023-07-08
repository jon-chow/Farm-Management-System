package com.server.service.interfaces;

import com.server.dto.UserDto;

public interface IUserService {
    public UserDto login(String username, String password);
    public UserDto logout();
}
