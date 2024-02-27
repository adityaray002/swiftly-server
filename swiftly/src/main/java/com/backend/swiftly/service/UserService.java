package com.backend.swiftly.service;

import com.backend.swiftly.entity.User;

import java.util.List;

public interface UserService {
     public User saveUser(User user);
     public List<User> getAllUsers();
}
