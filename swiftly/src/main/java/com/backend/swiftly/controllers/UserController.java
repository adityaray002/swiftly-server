package com.backend.swiftly.controllers;

import com.backend.swiftly.entity.User;
import com.backend.swiftly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        userService.saveUser(user);
        return "New User Created";
    }

    @GetMapping("/getusers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
