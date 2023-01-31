package org.nagarro.ProductMicroservice.dao;

import org.nagarro.ProductMicroservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
