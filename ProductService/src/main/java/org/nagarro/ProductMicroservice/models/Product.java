package org.nagarro.ProductMicroservice.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int productId;

    @Column(name = "product_size")
    private String size;

    @Column(name = "product_design")
    private String design;

    @Column(name = "product_price")
    private long price;


    public Product(int productId, String size, String design, long price, int userId) {
        this.productId = productId;
        this.size = size;
        this.design = design;
        this.price = price;
    }

    public Product() {
    }
}
