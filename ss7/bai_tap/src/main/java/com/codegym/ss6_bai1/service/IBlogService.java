package com.codegym.ss6_bai1.service;

import com.codegym.ss6_bai1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog>findAll();
    void create(Blog blog);
    void delete(Integer id);
    Blog findById(Integer id);
    Page<Blog> search(String name, Pageable pageable);


}
