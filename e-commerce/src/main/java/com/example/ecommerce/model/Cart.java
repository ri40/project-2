package com.example.ecommerce.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class Cart {
    @NotEmpty
    @Size(max = 3)
    private String id;
    @NotEmpty
    @Size(max = 3)
    private String userId;
    private ArrayList<Product> products;

    public Cart(String id, String userId) {
        this.id = id;
        this.userId = userId;
        this.products = new ArrayList<>();
    }
}
