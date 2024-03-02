package com.backend.swiftly.USER.controllers;

import com.backend.swiftly.USER.common.APIResponse;
import com.backend.swiftly.USER.entity.User;
import com.backend.swiftly.USER.common.CustomUser;
import com.backend.swiftly.USER.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;






    @PostMapping("/register")
    public APIResponse register(@RequestBody User user){

        return userService.saveUser(user);


    }

    @GetMapping("/getusers")
    public APIResponse getAllUsers(){
        return userService.getAllUsers();
    }




    @PostMapping("/sign-in")
    public APIResponse signin(@RequestBody CustomUser customUser){
        return  userService.Authentication(customUser);
//        HashMap<String,String> map = new  HashMap<String,String>();
//        if (result != null && !result.isEmpty()) {
//            map.put("result",result);
//        } else {
//            map.put("result",null);
//        }
//
//        return map;
    }

    @PostMapping("/home")
    public void home(){

    }

}
