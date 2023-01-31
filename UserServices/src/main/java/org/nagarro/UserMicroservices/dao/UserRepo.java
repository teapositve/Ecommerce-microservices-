package org.nagarro.UserMicroservices.dao;

import java.util.Optional;
import org.nagarro.UserMicroservices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
