package org.nagarro.UserMicroservices.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGenerator implements CommandLineRunner{
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(this.passwordEncoder.encode ("helloworld"));

    }
}
