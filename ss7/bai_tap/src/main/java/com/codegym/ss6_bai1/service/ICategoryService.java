package com.codegym.ss6_bai1.service;

import com.codegym.ss6_bai1.model.Blog;
import com.codegym.ss6_bai1.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    void create(Category category);
    void delete(Integer id);
    Category findById(Integer id);
}
