package org.nagarro.UserMicroservices.services;

import org.nagarro.UserMicroservices.models.User;

import java.util.List;

public interface UserService {

    //Register User
    User registerNewUser(User user);

    //Create User
    User createUser(User user);

    //Update User
    User updateUser(User user, Integer userId);

    //Get By Id
    User getUserById(Integer userId);

    //Get all User
    List<User> getAllUser();

    //Delete User
    void deleteUser(int userId);
}
