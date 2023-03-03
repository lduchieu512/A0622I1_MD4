package com.example.ss8_baitap.repository;

import com.example.ss8_baitap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}
