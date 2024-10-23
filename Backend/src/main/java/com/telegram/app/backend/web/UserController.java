package com.telegram.app.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class UserController {

    @PostMapping
    protected ResponseEntity<Void> registerUser(){
        return new ResponseEntity<>(null,null);
    }

    @PutMapping
    protected ResponseEntity<Void> updateUserInfo(){
        return new ResponseEntity<>(null,null);
    }
}
