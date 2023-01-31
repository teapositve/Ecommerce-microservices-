package org.nagarro.UserMicroservices.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    private int cartId;

    private String products;

    private int productId;

    private int userId;

}
