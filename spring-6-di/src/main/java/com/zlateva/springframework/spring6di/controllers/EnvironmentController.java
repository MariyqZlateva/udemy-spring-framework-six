package com.zlateva.springframework.spring6di.controllers;

import com.zlateva.springframework.spring6di.servises.EnvironmentService;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

    private final EnvironmentService environmentService;

    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String getEnvironment(){
        return "You are in "+ environmentService.getEnv() +" Environment";
    }
}
