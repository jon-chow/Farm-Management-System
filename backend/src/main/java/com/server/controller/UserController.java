package com.server.controller;

import com.server.bean.RestResult;
import com.server.dto.UserDto;
import com.server.service.interfaces.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private IUserService service;

    /**
     * Endpoint for user to create a session and Login
     *
     * Returns a JWT token
     *
     * POST /api/user/login
     */
    @PostMapping(value = "/login")
    //@RequestMapping(value = "/login")
    public RestResult<String> login(@RequestBody Map<String, Object> body) {
        String username = body.get("username").toString();
        String password = body.get("password").toString();
        System.out.println("Username: " + username + " password: " + password);
        String res = service.login(username, password);
        return RestResult.success(res);
    }

    @GetMapping(value = "/logout")
    public RestResult<UserDto> logout(){
        UserDto res = service.logout();
        return RestResult.success(res);
    }
}
