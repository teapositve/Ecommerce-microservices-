package org.nagarro.ProductMicroservice.models;

import lombok.Data;

@Data
public class Cart {

    private int cartId;

    private String products;

    private Product product;

    public Cart(int cartId, String products, Product product) {
        this.cartId = cartId;
        this.products = products;
        this.product = product;
    }

    public Cart() {
    }
}
