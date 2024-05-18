package com.example.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // stereotype annotation for restful web services @controller +@responseBody this annotation converts java object to response object to be consumed by client
@RequestMapping("/api") //used for defining base url
public class HelloWorldController {

    // http get request - http://localhost:8080/api/hello-world
    @GetMapping("/hello-world") //get mapping and map urls to the java method
    public String helloWorld(){
        return "Hello World";
    }
}
