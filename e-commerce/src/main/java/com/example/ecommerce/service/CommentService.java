package com.example.ecommerce.service;

import com.example.ecommerce.model.Comment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class CommentService {

    private ArrayList<Comment> comments=new ArrayList<>();

    public ArrayList<Comment> getComments() {
        return comments;
    }
}
