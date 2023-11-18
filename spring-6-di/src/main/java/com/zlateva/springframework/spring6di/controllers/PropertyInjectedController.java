package com.zlateva.springframework.spring6di.controllers;

import com.zlateva.springframework.spring6di.servises.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

    @Autowired
    GreetingService greetingService;
    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
