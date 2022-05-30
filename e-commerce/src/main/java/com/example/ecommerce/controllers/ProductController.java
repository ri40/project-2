package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Api;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ArrayList<Product>> getProduct(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }

    @PostMapping
    public ResponseEntity<Api> addProduct(@RequestBody @Valid Product product, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isAddProduct =productService.addProducts(product);
        if (!isAddProduct) {
            return ResponseEntity.status(400).body(new Api("Not Found Product!", 400));
        }
        return ResponseEntity.status(201).body(new Api("Product added!", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity<Api> updateProduct(@RequestBody @Valid Product product,@PathVariable Integer index, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isUpdateProduct =productService.updateProducts(index, product);
        if (!isUpdateProduct) {
            return ResponseEntity.status(400).body(new Api(" Not found Product", 400));
        }
        return ResponseEntity.status(200).body(new Api("update Product", 200));
    }
    @DeleteMapping("{index}")
    public ResponseEntity<Api> deleteProduct(@PathVariable Integer index) {
        boolean isDeleteProduct =productService.deleteProducts(index);
        if (!isDeleteProduct) {
            return ResponseEntity.status(400).body(new Api(" Not found Product", 400));
        }
        return ResponseEntity.status(200).body(new Api("delete Product", 200));
    }
}
