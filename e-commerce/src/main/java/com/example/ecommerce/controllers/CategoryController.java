package com.example.ecommerce.controllers;

import com.example.ecommerce.model.Api;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor

public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ArrayList<Category>> getCategory(){
        return ResponseEntity.status(200).body(categoryService.getCategories());
    }

    @PostMapping
    public ResponseEntity<Api> addCategory(@RequestBody @Valid Category category, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isAddCategories =categoryService.addCategories(category);
        if (!isAddCategories) {
            return ResponseEntity.status(400).body(new Api("Not Found Category!", 400));
        }
        return ResponseEntity.status(201).body(new Api("Category added!", 201));
    }

    @PutMapping("{index}")
    public ResponseEntity<Api> updateCategory(@RequestBody @Valid Category category, @PathVariable Integer index, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
        }
        boolean isUpdateCategories =categoryService.updateCategories(index,category);
        if (!isUpdateCategories) {
            return ResponseEntity.status(400).body(new Api(" Not found Category", 400));
        }
        return ResponseEntity.status(200).body(new Api("update Category", 200));
    }

    @DeleteMapping("{index}")
    public ResponseEntity<Api> deleteCategory(@PathVariable Integer index) {
        boolean isDeleteCategories =categoryService.deleteCategories(index);
        if (!isDeleteCategories) {
            return ResponseEntity.status(400).body(new Api(" Not found Category", 400));
        }
        return ResponseEntity.status(200).body(new Api("delete Category", 200));
    }
}
