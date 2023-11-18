package com.zlateva.springframework.spring6di.controllers;

import com.zlateva.springframework.spring6di.servises.GreetingService;
import com.zlateva.springframework.spring6di.servises.GreetingServiceImpl;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    private final GreetingService greetingService;

    public MyController() {
        this.greetingService = new GreetingServiceImpl();
    }

    public String sayHello(){
        System.out.println("I'm in the controller");

        return greetingService.sayGreeting();
    }
}
