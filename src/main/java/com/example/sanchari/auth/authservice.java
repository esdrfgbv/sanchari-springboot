package com.example.sanchari.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class authservice {
    @Autowired
    authrepo authrepo;

    public ResponseEntity<List<authmodel>> getAllUsers() {
        return new ResponseEntity<>(authrepo.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> addUsers(authmodel authmodel) {
        authrepo.save(authmodel);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<String> findUser(authmodel authmodel) {
        authmodel existingUser = authrepo.findByUsername(authmodel.getUsername());

        if (existingUser == null) {
            return new ResponseEntity<>("User Not Found", HttpStatus.UNAUTHORIZED);
        }

        if (!existingUser.getPassword().equals(authmodel.getPassword())) {
            return new ResponseEntity<>("Invalid Password", HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }

}
