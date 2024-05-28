package com.backend.swiftly.USER.service;

import com.backend.swiftly.USER.common.APIResponse;
import com.backend.swiftly.USER.entity.User;
import com.backend.swiftly.USER.exceptions.UserNotFoundException;
import com.backend.swiftly.USER.repository.UserRepo;
import com.backend.swiftly.USER.common.CustomUser;
import org.apache.catalina.startup.PasswdUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepo repo;





    @Override
    public APIResponse saveUser(User user) {
        if(repo.findByEmail(user.getEmail())==null){
            BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
            String encryptedPwd=bcrypt.encode(user.getPassword());
            user.setPassword(encryptedPwd);
            int check = ResponseEntity.status(HttpStatus.CREATED).build().getStatusCode().value();
            System.out.println(check);
            User result=repo.save(user);
            APIResponse response = new APIResponse(check,result,false);
            response.setStatus(check);
            response.setData(user);
            response.setIsError(false);
            System.out.println(response.getData());
            return response;
        }else if(repo.findByEmail(user.getEmail())!=null){
//        boolean vendorExists = true;
            com.backend.swiftly.USER.common.APIResponse response = new com.backend.swiftly.USER.common.APIResponse(200, null,false);
            response.setStatus(200);
            response.setData("message:User already exists");
            response.setIsError(false);
            System.out.println(response.getData());
            return response;
        }

        return new APIResponse(200,null,true);



    }


    public APIResponse authenticateUser(CustomUser customUser) {
        APIResponse response = new APIResponse(200,"No user is not found for this email!!!",false);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Optional<User> opUser = Optional.ofNullable(repo.findByEmail(customUser.getEmail()));

        if(opUser.isPresent()){
            User dbUser=opUser.get();
            if(bcrypt.matches(customUser.getPassword(), dbUser.getPassword())){
                response.setData("Authenticated User");
                return response;
            }

            else{
                response.setData("Incorrect Password");
                return response;
            }



        }
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




//    @Override
//    public APIResponse Authentication(CustomUser customUser){
//        APIResponse response = new APIResponse(201,null,null);
//
//        List<User> users = repo.findAll();
//
//        for (User user : users) {
//            if (user.getEmail().equals(customUser.getEmail()) && user.getPassword().equals(customUser.getPassword())) {
//                response.setData(user);
//                response.setStatus(200);
//
//                break;
//
//            }
//        }
//        return response;
//    }
}
