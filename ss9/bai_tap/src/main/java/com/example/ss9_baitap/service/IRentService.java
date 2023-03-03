package com.example.ss9_baitap.service;

import com.example.ss9_baitap.model.Rent;

import java.util.Optional;

public interface IRentService {
    void save(Rent rent);

    Iterable<Rent> findAll();

    Optional<Rent> findById(Long id);
}
