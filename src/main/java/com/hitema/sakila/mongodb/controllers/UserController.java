package com.hitema.sakila.mongodb.controllers;


import com.hitema.sakila.mongodb.models.User;
import com.hitema.sakila.mongodb.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("/{email}")
    User getOne(@PathVariable String email){
        return service.read(email);
    }

    @PostMapping (value = "/picture/{email}", consumes = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    Boolean savePicture(@PathVariable String email, @RequestBody byte[] picture){
        service.savePicture(email, picture);
        return (service.getPicture(email)!=null);
    }

    @GetMapping(value = "/picture/{email}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    byte[] getPicture(@PathVariable String email){
        return service.getPicture(email);
    }
    @GetMapping("/all")
    List<User> getAll(){
        return service.readAll();
    }

    @GetMapping("/name/{expr}")
    List<User> getAll(@PathVariable String expr){
        return service.searchBy(expr);
    }
}
