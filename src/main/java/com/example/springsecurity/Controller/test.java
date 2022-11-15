package com.example.springsecurity.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class test {
    @GetMapping("/test")
    public ResponseEntity<?> signUp(){
        System.out.println("hey");
        return new ResponseEntity<>("Suser", HttpStatus.CREATED);
    }

}
