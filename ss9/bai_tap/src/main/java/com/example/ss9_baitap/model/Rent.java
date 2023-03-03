package com.example.ss9_baitap.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


import javax.persistence.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false, referencedColumnName = "id")
    private Book book;


}
