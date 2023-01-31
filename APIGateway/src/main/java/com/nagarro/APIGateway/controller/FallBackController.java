package com.nagarro.APIGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/userservicefallback")
    public String UserServiceFallback(){
        return  "User service down at this time !!";
    }

    @GetMapping("/productservicefallback")
    public String ProductServiceFallback(){
        return "Product service down at this time";
    }
}