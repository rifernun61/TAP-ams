package com.tapamsrichard.tapams.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    
    @GetMapping
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok("Hello World");
    }
    
    @GetMapping(value = "/{name}")
    public ResponseEntity<String> postMethodName(@PathVariable String name) {        
        return ResponseEntity.ok("Hello " + name);
    }
    
}
