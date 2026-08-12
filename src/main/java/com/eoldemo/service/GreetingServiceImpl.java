package com.eoldemo.service;

import org.springframework.stereotype.Component;

@Component
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name) {
        return "Hello, " + (name == null ? "World" : name) + "!";
    }
}
