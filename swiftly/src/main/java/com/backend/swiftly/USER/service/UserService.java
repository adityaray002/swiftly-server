package com.backend.swiftly.USER.service;

import com.backend.swiftly.USER.common.APIResponse;
import com.backend.swiftly.USER.common.CustomUser;
import com.backend.swiftly.USER.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
      public APIResponse saveUser(User user);
     public APIResponse getAllUsers();

    public APIResponse Authentication(CustomUser customUser);


  //   public User getUserByid(int id);
}
