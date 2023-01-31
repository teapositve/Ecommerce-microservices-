package org.nagarro.ProductMicroservice.services;

import org.nagarro.ProductMicroservice.models.Product;

import java.util.List;

public interface ProductService {

    //Create
    Product createProduct(Product product);

    //Update
    Product updateProduct(Product product, Integer productId);

    //Get all
    List<Product> getAllProducts();

    //Get Single
    Product getSingleProduct(Integer productId);

    //Delete
    void deleteProduct(Integer productId);
}
