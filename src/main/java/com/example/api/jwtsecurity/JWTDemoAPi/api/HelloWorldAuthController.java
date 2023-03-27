package com.example.api.jwtsecurity.JWTDemoAPi.api;

import com.example.api.jwtsecurity.JWTDemoAPi.model.ClientEntity;
import com.example.api.jwtsecurity.JWTDemoAPi.util.JWTTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloWorldAuthController {

    @Autowired
    private JWTTokenUtil jwtTokenUtil;
    public static List<String> clientIDList = Arrays.asList("app1", "app2", "app3");

    @PostMapping(value = "/auth", consumes = "application/json", produces = "text/plain")
    public ResponseEntity<?> authorization(@RequestBody ClientEntity clientEntity){
        System.out.println("ClientID :" + clientEntity.getClientID());

        if(clientIDList.stream().anyMatch(listItem -> listItem.equalsIgnoreCase(clientEntity.getClientID()))){
            return ResponseEntity.ok(jwtTokenUtil.getJWT());
        }

        return ResponseEntity.internalServerError().body("ClientID not found in our system");
    }

}
