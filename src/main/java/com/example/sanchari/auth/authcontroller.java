package com.example.sanchari.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class authcontroller {
    @Autowired
    private authservice authservice;

    @GetMapping("/getusers")
    public ResponseEntity<List<authmodel>> getusers() {
        return authservice.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody authmodel authmodel) {
        return authservice.addUsers(authmodel);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody authmodel authmodel) {
        try {
            return authservice.findUser(authmodel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Not Found Please Register");
        }

    }
}
