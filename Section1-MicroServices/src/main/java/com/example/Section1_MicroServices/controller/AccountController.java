package com.example.Section1_MicroServices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/sayHello")
    public String greet()
    {
        return "hello World";
    }
}
