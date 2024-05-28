package com.backend.swiftly.USER.controllers;

import com.backend.swiftly.BOOKING.entity.Booking;
import com.backend.swiftly.BOOKING.service.BookingService;
import com.backend.swiftly.USER.common.APIResponse;
import com.backend.swiftly.USER.entity.User;
import com.backend.swiftly.USER.common.CustomUser;
import com.backend.swiftly.USER.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;


    @PostMapping("/register")
    public APIResponse register(@RequestBody User user){
         APIResponse savedUser =  userService.saveUser(user);
         if(savedUser!=null){
             return savedUser;
         }else{
             System.out.println("s,ufgasgf");
             return null;
         }

    }

    @PostMapping("/authenticateUsers")
    public APIResponse authenticateUser(@RequestBody CustomUser customUser) throws UserPrincipalNotFoundException {
        return userService.authenticateUser(customUser);
    }

    @GetMapping("/getusers")
    public APIResponse getAllUsers(){
        return userService.getAllUsers();
    }






}
