package com.example.ecommerce.service;

import com.example.ecommerce.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserService {

    private ArrayList<User> users = new ArrayList<>();

    public final CartService cartService;
    public final ProductService productService;
    public final MerchantStockService merchantStockService;
    public final PurchaseHistoryService purchaseHistoryService;

    public ArrayList<User> getUsers() {
        return users;
    }

    public boolean addUsers(User user) {
        return users.add(user);
    }

    public boolean updateUsers(Integer index, User user) {
        if (index > users.size() - 1 || index < 0) {
            return false;
        }
        User currentUser = users.set(index, user);
        return true;
    }

    public boolean deleteUsers(Integer index) {
        if (index > users.size() - 1 || index < 0) {
            return false;
        }
        users.remove((int) index);
        return true;
    }

    ////////////////================////////////////
    public Integer addProductToACart(String userId, String productId) {
        User user = getUserId(userId);
        if (user == null) {
            return -1;
        }
        Product product = productService.getproductID(productId);
        if (product == null) {
            return 0;
        }
        Cart cart = cartService.getUserCart(userId);
        ArrayList<Product> products = cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        return 1;
    }

    private User getUserId(String userId) {
        for (User user : users) {
            if (user.getId().equals(userId))
                return user;
        }
        return null;
    }

    public Integer deleteProductToACart(String userId, String productId) {
        User user = getUserId(userId);
        if (user == null) {
            return -1;
        }
        Product product = productService.getproductID(productId);
        if (product == null) {
            return 0;
        }
        Cart cart = cartService.getUserCart(userId);
        ArrayList<Product> products = cart.getProducts();
        products.remove(product);
        return 1;
    }

    public Integer addProductToAMerchantStock(String productId, String merchantId, Integer stock) {
        Product product = productService.getproductID(productId);
        if (product == null) {
            return 0;
        }
        for (MerchantStock merchantStock : merchantStockService.getMerchantStocks()) {
            if (merchantStockService.getmerchantID(merchantId).equals(merchantId)) {
                merchantStock.setStock(merchantStock.getStock() + stock);
            }
        }
            return 1;
        }

    public ArrayList getComments(String productId){
        Product product = productService.getproductID(productId);
        if(product != null){
            return product.getComments();
        }
        return null;
    }

    public ArrayList<Product> getFiveRates(){
        ArrayList<Product> productsFiveRate = new ArrayList<>();
        for(Product product : productService.getProducts()){
            for(Comment comment: product.getComments()){
                if (comment.getRate() == 5){
                    productsFiveRate.add(product);
                }
            }
        }
        return productsFiveRate;
    }

    public ArrayList getPurchaseHistory() {
        return purchaseHistoryService.getPurchaseHistories();
    }

}
