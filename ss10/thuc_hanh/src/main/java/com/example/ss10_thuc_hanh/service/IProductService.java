package com.example.ss10_thuc_hanh.service;

import com.example.ss10_thuc_hanh.models.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
