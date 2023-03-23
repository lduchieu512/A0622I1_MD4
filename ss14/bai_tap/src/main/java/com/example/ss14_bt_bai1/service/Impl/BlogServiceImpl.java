package com.example.ss14_bt_bai1.service.Impl;

import com.example.ss14_bt_bai1.model.Blog;
import com.example.ss14_bt_bai1.repository.IBlogRepository;
import com.example.ss14_bt_bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository repository;


    @Override
    public List<Blog> finAll() {
        return repository.findAll();
    }

    @Override
    public Blog save(Blog blog) {
        return repository.save(blog);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
