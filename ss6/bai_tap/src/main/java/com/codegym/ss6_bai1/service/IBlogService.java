package com.codegym.ss6_bai1.service;

import com.codegym.ss6_bai1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog>findAll();
    void create(Blog blog);
    void delete(Integer id);
    Blog findById(Integer id);


}
