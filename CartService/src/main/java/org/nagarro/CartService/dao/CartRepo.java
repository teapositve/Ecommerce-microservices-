package org.nagarro.CartService.dao;

import org.nagarro.CartService.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

    public List<Cart> findByUser(Integer user);
}
