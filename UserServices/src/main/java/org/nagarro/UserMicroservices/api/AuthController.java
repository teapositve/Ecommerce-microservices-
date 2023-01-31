package org.nagarro.UserMicroservices.api;

import org.nagarro.UserMicroservices.exceptions.ApiException;
import org.nagarro.UserMicroservices.models.User;
import org.nagarro.UserMicroservices.security.JwtAuthRequest;
import org.nagarro.UserMicroservices.security.JwtAuthResponse;
import org.nagarro.UserMicroservices.security.JwtTokenHelper;
import org.nagarro.UserMicroservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    JwtTokenHelper jwtTokenHelper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> loginUser(@RequestBody JwtAuthRequest authRequest) throws Exception {

        this.authenticationManager(authRequest.getUsername(), authRequest.getPassword());
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authRequest.getUsername());
        String token = this.jwtTokenHelper.generateToken(userDetails);
        System.out.println("Login api called");

        JwtAuthResponse authResponse = new JwtAuthResponse();
        authResponse.setToken(token);
        return new ResponseEntity<JwtAuthResponse>(authResponse, HttpStatus.OK);
    }

    private void authenticationManager(String username, String password) throws Exception {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            this.authenticationManager.authenticate(authenticationToken);
        } catch (BadCredentialsException e) {
            System.out.println("Invalid Credentials");
            throw new ApiException("Invalid Username and Password");
        }
    }


    //Register New user api
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
        User registeredUser = this.userService.registerNewUser(user);
        return new ResponseEntity<User>(registeredUser,HttpStatus.CREATED);
    }

}
