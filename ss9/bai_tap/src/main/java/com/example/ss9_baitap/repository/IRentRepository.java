package com.example.ss9_baitap.repository;

import com.example.ss9_baitap.model.Book;
import com.example.ss9_baitap.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRentRepository extends JpaRepository<Rent,Long> {
   @Query(value = "select r from Rent r where r.status ='on'")
    List<Rent> findAll();

    @Query(value = "select r from Rent r where r.status ='on' and r.id = :id")
    Optional<Rent> findById(@Param("id") Long id);



}
