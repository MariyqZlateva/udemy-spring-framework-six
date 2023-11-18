package com.zlateva.springframework.spring6di.servises;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile({"dev", "default"})
@Service
public class EnvironmentServiceDev implements EnvironmentService {
    @Override
    public String getEnv() {
        return "dev";
    }
}
