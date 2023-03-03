package com.example.ss9_baitap.repository;

import com.example.ss9_baitap.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {
}
