package com.example.ss10_thuc_hanh.repository;

import com.example.ss10_thuc_hanh.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Long> {
}
