package com.zlateva.springframework.spring6di.servises;

import org.springframework.stereotype.Service;

@Service("setterGreetingBean")
public class GreetingServiceSetterInjection implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hey I'm Setting a Greeting";
    }
}
