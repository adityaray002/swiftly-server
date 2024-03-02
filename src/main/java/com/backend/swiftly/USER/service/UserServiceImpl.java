package com.backend.swiftly.USER.service;

import com.backend.swiftly.USER.common.APIResponse;
import com.backend.swiftly.USER.entity.User;
import com.backend.swiftly.USER.repository.UserRepo;
import com.backend.swiftly.USER.common.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepo repo;




    @Override
    public APIResponse saveUser(User user) {

        User result=repo.save(user);
        APIResponse response = new APIResponse(200,result,null);
        response.setStatus(200);
        response.setData(user);
        response.setError(null);
        return response;



    }

    @Override
    public APIResponse getAllUsers() {

        List<User> users =  repo.findAll();
        APIResponse response = new APIResponse(200,users,null);
        return response;
    }

//    public User getUserByid(int id){
//
//        return repo.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + id));
//
//    }
//




    @Override
    public APIResponse Authentication(CustomUser customUser){
        APIResponse response = new APIResponse(201,null,null);

        List<User> users = repo.findAll();

        for (User user : users) {
            if (user.getEmail().equals(customUser.getEmail()) && user.getPassword().equals(customUser.getPassword())) {
                response.setData(user);
                response.setStatus(200);
          
                break;

            }
        }
        return response;
    }
}
