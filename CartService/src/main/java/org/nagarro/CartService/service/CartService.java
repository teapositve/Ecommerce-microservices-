package org.nagarro.CartService.service;

import org.nagarro.CartService.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

    Cart addProduct(Integer productId, Integer userId);

    List<Cart> getCart(Integer userId);

    void deleteProduct(Integer productId, Integer userId);
}
