package com.server.service.interfaces;

import com.server.dto.AuthDto;

public interface IAuthService {
    public String login(String username, String password);
    public AuthDto logout();
    public String refreshToken(String token);
}
