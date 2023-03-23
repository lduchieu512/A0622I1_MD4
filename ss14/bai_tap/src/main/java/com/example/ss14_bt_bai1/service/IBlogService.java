package com.example.ss14_bt_bai1.service;

import com.example.ss14_bt_bai1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> finAll();
    Blog save(Blog blog);
    void remove(Long id);
}
