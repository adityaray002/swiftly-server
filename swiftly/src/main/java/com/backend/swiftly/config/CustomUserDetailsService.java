package com.backend.swiftly.config;

import com.backend.swiftly.entity.User;
import com.backend.swiftly.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("User not Found");
        }else{
            return new CustomUser(user);
        }

    }
}
