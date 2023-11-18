package com.zlateva.springframework.spring6di.controllers;

import com.zlateva.springframework.spring6di.servises.GreetingService;

public class PropertyInjectedController {

    GreetingService greetingService;
    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
