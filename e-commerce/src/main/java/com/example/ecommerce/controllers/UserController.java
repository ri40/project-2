package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Api;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<ArrayList<User>> getUser(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<Api> addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isAddUser =userService.addUsers(user);
        if (!isAddUser) {
            return ResponseEntity.status(400).body(new Api("Not Found User!", 400));
        }
        return ResponseEntity.status(201).body(new Api("User added!", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity<Api> updateUser(@RequestBody @Valid User user, @PathVariable Integer index, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isUpdateUser =userService.updateUsers(index,user);
        if (!isUpdateUser) {
            return ResponseEntity.status(400).body(new Api(" Not found User", 400));
        }
        return ResponseEntity.status(200).body(new Api("update User", 200));
    }
    @DeleteMapping("{index}")
    public ResponseEntity<Api> deleteUser(@PathVariable Integer index) {
        boolean isDeleteUser =userService.deleteUsers(index);
        if (!isDeleteUser) {
            return ResponseEntity.status(400).body(new Api(" Not found User", 400));
        }
        return ResponseEntity.status(200).body(new Api("delete User", 200));
    }
    ///////////////////==================================////////////////////

    @PutMapping("add/{userId}/{productId}")
    public ResponseEntity<Api> addProductToACart(@PathVariable String userId,@PathVariable String productId) {
        Integer cartAdd = userService.addProductToACart(userId, productId);
        switch (cartAdd) {
            case -1:
                return ResponseEntity.status(400).body(new Api("user id not found ", 400));
            case 0:
                return ResponseEntity.status(400).body(new Api("product id not found ", 400));
            case 1:
                return ResponseEntity.status(200).body(new Api("product add to cart ", 200));
            default:
                return ResponseEntity.status(500).body(new Api("server error  ", 500));
        }
    }
    @PutMapping("delete/{userId}/{productId}")
    public ResponseEntity<Api> deleteProductToACart(@PathVariable String userId,@PathVariable String productId ){
        Integer cartDelete = userService.deleteProductToACart(userId,productId);
        switch (cartDelete){
            case -1:
                return ResponseEntity.status(400).body(new Api("user id not found ",400));
            case 0:
                return ResponseEntity.status(400).body(new Api("product id not found ",400));
            case 1:
                return ResponseEntity.status(200).body(new Api("product deleted from cart ",200));
            default:
                return ResponseEntity.status(500).body(new Api("server error  ",500));
        }
    }

    @PutMapping("addtomerchantstock/{merchantId}/{productId}/{amount}")
    public ResponseEntity<Api> addProductToAMerchantStock(@PathVariable String merchantId,@PathVariable String productId,@PathVariable Integer amount ) {
        Integer cartAdd = userService.addProductToAMerchantStock(merchantId, productId, amount);
        switch (cartAdd) {
            case 0:
                return ResponseEntity.status(400).body(new Api("product id not found ", 400));
            case 1:
                return ResponseEntity.status(201).body(new Api("product added ", 201));
            default:
                return ResponseEntity.status(500).body(new Api("server error  ", 500));
        }
    }
        @GetMapping("/allcomments")
        public ResponseEntity getComments(String productId){
            ArrayList comments = userService.getComments(productId);
            if( comments != null){
                return ResponseEntity.status(200).body(comments);
            }
            return ResponseEntity.status(400).body(new Api("User id not found", 400));
        }

        @PostMapping ("rate5products")
        public ResponseEntity getFiveRate(){
            return ResponseEntity.status(200).body(userService.getFiveRates());
        }

        @PostMapping("allpurchasehistory")
        public ResponseEntity getPurchaseHistory(){
            return ResponseEntity.status(200).body(userService.getPurchaseHistory());
        }
}
