package com.zlateva.springframework.spring6di.servises;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
@Profile("qa")
@Service
public class EnvironmentServiceQA implements EnvironmentService{
    @Override
    public String getEnv() {
        return "qa";
    }
}
