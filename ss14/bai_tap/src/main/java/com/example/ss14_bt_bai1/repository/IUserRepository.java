package com.example.ss14_bt_bai1.repository;

import com.example.ss14_bt_bai1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<Customer,Long> {
    Customer findByUsername(String username);
}
