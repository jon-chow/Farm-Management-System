package com.server;

import com.server.controller.LivestockController;
import com.server.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.server.controller.MainController;

// Server for requesting API calls
@SpringBootApplication
public class FarmingManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FarmingManagementSystemApplication.class);
        app.addInitializers((applicationContext) -> {
            applicationContext.getBeanFactory().registerSingleton("mainController", new MainController());
            applicationContext.getBeanFactory().registerSingleton("livestockController", new LivestockController());
            applicationContext.getBeanFactory().registerSingleton("userController", new UserController());
        });
        app.run(args);
    }
}
