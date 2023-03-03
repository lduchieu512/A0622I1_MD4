package com.example.ss9_baitap.service.Impl;

import com.example.ss9_baitap.model.Rent;
import com.example.ss9_baitap.repository.IRentRepository;
import com.example.ss9_baitap.service.IRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentService implements IRentService {
    @Autowired
    private IRentRepository iRentRepository;


    @Override
    public void save(Rent rent) {
        iRentRepository.save(rent);
    }

    @Override
    public Iterable<Rent> findAll() {
        return iRentRepository.findAll();
    }

    @Override
    public Optional<Rent> findById(Long id) {
        return iRentRepository.findById(id);
    }
}
