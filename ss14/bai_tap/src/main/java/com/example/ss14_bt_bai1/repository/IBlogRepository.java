package com.example.ss14_bt_bai1.repository;

import com.example.ss14_bt_bai1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
}
