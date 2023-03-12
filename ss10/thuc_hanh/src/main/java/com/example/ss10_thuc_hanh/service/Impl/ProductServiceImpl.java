package com.example.ss10_thuc_hanh.service.Impl;

import com.example.ss10_thuc_hanh.models.Product;
import com.example.ss10_thuc_hanh.repository.IProductRepository;
import com.example.ss10_thuc_hanh.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {

        return iProductRepository.findById(id);
    }
}
