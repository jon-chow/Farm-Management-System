package com.server.controller;

import com.server.bean.RestResult;
import com.server.dto.UserDto;
import com.server.service.interfaces.IUserService;
import com.server.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
// @CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/user")
// TODO
public class UserController {

    @Autowired
    private IUserService service;
}
