package org.nagarro.UserMicroservices.dao;

import org.nagarro.UserMicroservices.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
