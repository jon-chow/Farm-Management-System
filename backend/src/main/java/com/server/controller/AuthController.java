package com.server.controller;

import com.server.bean.RestResult;
import com.server.dto.AuthDto;
import com.server.service.interfaces.IAuthService;
import com.server.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/auth")
public class AuthController {

    @Autowired
    private IAuthService service;

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
        String res = service.login(username, password);
        return RestResult.success(res);
    }

    /**
     * Endpoint for user to logout
     *
     * GET /api/user/logout
     */
    @GetMapping(value = "/logout")
    public RestResult<AuthDto> logout(){
        AuthDto res = service.logout();
        return RestResult.success(res);
    }

    @PostMapping(value = "/testToken")
    public RestResult<String> getUserById(@RequestBody Map<String, Object> body) {
        String token = body.get("token").toString();

        if (!JwtUtils.validateToken(token)) {
            return RestResult.fail("err", "invalid credentials");
        }

        return RestResult.success("ok");
    }

//    @GetMapping(value = "/testToken")
//    public RestResult<String> getUserById(@PathVariable("userId") final long userId) {
//        return RestResult.success("ok");
//    }
}
