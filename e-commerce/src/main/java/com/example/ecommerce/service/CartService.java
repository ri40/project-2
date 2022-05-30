package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CartService {
    private ArrayList<Cart> carts = new ArrayList<>();
    public ArrayList<Cart> getCarts() {
        return carts;
    }

    public Cart getUserCart(String userId) {
        for(Cart cart:carts){
            if(cart.getUserId().equals(userId))
                return cart;
        }
        Cart cart =new Cart(userId,userId);
        return cart;
    }
}
