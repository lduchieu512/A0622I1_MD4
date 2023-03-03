package com.example.ss9_baitap.service.Impl;

import com.example.ss9_baitap.model.Book;
import com.example.ss9_baitap.repository.IBookRepository;
import com.example.ss9_baitap.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public Iterable<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }
}
