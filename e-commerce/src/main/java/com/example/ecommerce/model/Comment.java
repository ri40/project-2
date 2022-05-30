package com.example.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor
@Data
public class Comment {
    @NotEmpty
    @Size(max = 3)
    private String id;
    @NotEmpty
    @Size(max = 5)
    private String userId;
    @NotEmpty
    @Size(max = 6)
    private String message;
    @NotNull
    @Range(min = 1,max = 5)
    private Integer rate;
}
