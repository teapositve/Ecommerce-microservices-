package org.nagarro.UserMicroservices.security;

import org.nagarro.UserMicroservices.dao.UserRepo;
import org.nagarro.UserMicroservices.exceptions.ResourceNotFoundException;
import org.nagarro.UserMicroservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Loading User from DB by username
        User user = this.userRepo.findByEmail(username).
                orElseThrow(() -> new ResourceNotFoundException("User", "Email : "+username, 0));
        return user;
    }
}
