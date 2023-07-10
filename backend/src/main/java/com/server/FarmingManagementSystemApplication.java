package com.server;

import com.server.controller.LivestockController;
import com.server.controller.UserController;
import com.server.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.server.controller.MainController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

// Server for requesting API calls
@SpringBootApplication
@Import(MyBatisConfig.class)
public class FarmingManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(FarmingManagementSystemApplication.class);
        app.run(args);
    }

    @Configuration
    @ImportResource({"classpath*:applicationContext.xml"})
    public class XmlConfiguration {
    }
}
