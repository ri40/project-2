package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@AllArgsConstructor
@Data

public class Product {
    @NotEmpty
    @Size(max = 3)
    private String id;
    @NotEmpty
    @Size(max = 3)
    private String name;
    @NotNull
    @Positive
    private Integer price;
    @NotEmpty
    @Size(max = 3)
    private String categoryID;
    private ArrayList<Comment> comments;
}
