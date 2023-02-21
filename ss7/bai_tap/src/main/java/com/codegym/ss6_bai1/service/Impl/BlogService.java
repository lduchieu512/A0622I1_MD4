package com.codegym.ss6_bai1.service.Impl;

import com.codegym.ss6_bai1.model.Blog;
import com.codegym.ss6_bai1.repository.BlogRepository;
import com.codegym.ss6_bai1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogRepository repository;

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Blog findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return repository.seachPage("%"+name+"%", pageable);
    }
}
