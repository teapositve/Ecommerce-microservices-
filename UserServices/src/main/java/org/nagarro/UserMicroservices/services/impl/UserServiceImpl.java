package org.nagarro.UserMicroservices.services.impl;

import org.nagarro.UserMicroservices.constant.AppConstant;
import org.nagarro.UserMicroservices.dao.RoleRepo;
import org.nagarro.UserMicroservices.dao.UserRepo;
import org.nagarro.UserMicroservices.exceptions.ResourceNotFoundException;
import org.nagarro.UserMicroservices.models.Role;
import org.nagarro.UserMicroservices.models.User;
import org.nagarro.UserMicroservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    PasswordEncoder passwordEncoder;


//    @Override
    public User registerNewUser(User user) {

        //Password Encoded
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        //Role
        Role role = this.roleRepo.findById(AppConstant.ROLE_NORMAL).get();

        user.getRoles().add(role);

        User newUser = this.userRepo.save(user);
        return newUser;
    }

    @Override
    public User createUser(User user) {

        User savedUser = this.userRepo.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(User user, Integer userId) {

        User updatedUser = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());

        User savedUpdatedUser = this.userRepo.save(updatedUser);
        return savedUpdatedUser;
    }

    @Override
    public User getUserById(Integer userId) {

        User getUser = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return getUser;
    }

    @Override
    public List<User> getAllUser() {

        List<User> users = this.userRepo.findAll();
        return users;
    }

    @Override
    public void deleteUser(int userId) {

        User delUser = this.userRepo.findById(userId).orElseThrow(() -> new  ResourceNotFoundException("User", "Id", userId));
        this.userRepo.delete(delUser);
    }
}
