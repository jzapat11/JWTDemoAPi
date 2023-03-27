package com.example.api.jwtsecurity.JWTDemoAPi.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/hello")
    public ResponseEntity<String> helloWorld(){

        return ResponseEntity.ok("Hello World JWT");
    }
}