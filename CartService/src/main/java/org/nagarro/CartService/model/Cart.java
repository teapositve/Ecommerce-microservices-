package org.nagarro.CartService.model;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Data
@Entity
@Table(name = "cart_items")
public class Cart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


}
