package org.nagarro.CartService.service.impl;

import org.nagarro.CartService.dao.CartRepo;
import org.nagarro.CartService.model.Cart;
import org.nagarro.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepo cartRepo;

    @Override
    public Cart addProduct(Integer productId, Integer userId) {

        return null;
    }

    @Override
    public List<Cart> getCart(Integer userId) {

        List<Cart> carts = cartRepo.findByUser(userId);
        return carts;
    }

    @Override
    public void deleteProduct(Integer productId, Integer userId) {

    }
}
