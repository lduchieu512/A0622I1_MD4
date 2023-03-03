package com.example.ss9_baitap.service;

import com.example.ss9_baitap.model.Book;

import java.util.Optional;

public interface IBookService {
    Iterable<Book> findAll();

    Optional<Book> findById(Long id);

    void save(Book book);
}
