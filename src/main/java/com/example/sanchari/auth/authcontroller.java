package com.example.sanchari.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authcontroller {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
