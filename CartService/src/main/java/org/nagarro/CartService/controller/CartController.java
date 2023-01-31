package org.nagarro.CartService.controller;

import org.nagarro.CartService.model.Cart;
import org.nagarro.CartService.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/cart/{userId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable Integer userId){
        return ResponseEntity.ok(this.cartService.getCart(userId));
    }
}
