package org.nagarro.ProductMicroservice.services.impl;

import org.apache.catalina.User;
import org.nagarro.ProductMicroservice.Exceptions.ResourceNotFoundException;
import org.nagarro.ProductMicroservice.dao.ProductRepo;
import org.nagarro.ProductMicroservice.models.Product;
import org.nagarro.ProductMicroservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    //Create
    @Override
    public Product createProduct(Product product) {

        Product createdProduct = this.productRepo.save(product);
        return createdProduct;
    }

    //Update
    @Override
    public Product updateProduct(Product product, Integer productId) {

        Product updatedProduct = this.productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", productId));

        updatedProduct.setSize(product.getSize());
        updatedProduct.setDesign(product.getDesign());
        updatedProduct.setPrice(product.getPrice());

        Product savedUpdatedProduct = this.productRepo.save(updatedProduct);
        return savedUpdatedProduct;
    }

    //Get All
    @Override
    public List<Product> getAllProducts() {

        List<Product> product = this.productRepo.findAll();
        return product;
    }

    //Get Single
    @Override
    public Product getSingleProduct(Integer productId) {

        Product getProduct = this.productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", productId));
        return getProduct;
    }

    //Delete
    @Override
    public void deleteProduct(Integer productId) {

        Product deleteProduct = this.productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "Product Id", productId));
        this.productRepo.delete(deleteProduct);
    }
}
