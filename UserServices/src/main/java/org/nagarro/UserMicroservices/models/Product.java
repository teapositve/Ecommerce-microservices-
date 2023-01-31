package org.nagarro.UserMicroservices.models;

import lombok.Data;

import javax.persistence.Column;

@Data
public class Product {

    private  int productId;
    private String size;
    private String design;
    private long price;


    public Product(int productId, String size, String design, long price) {
        this.productId = productId;
        this.size = size;
        this.design = design;
        this.price = price;

    }

    public Product() {
    }
}
