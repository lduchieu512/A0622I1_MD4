package com.codegym.ss6_bai1.repository;

import com.codegym.ss6_bai1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where name like ?",nativeQuery = true)
    Page<Blog>seachPage(@Param("name") String name, Pageable pageable);
}
