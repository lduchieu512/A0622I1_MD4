package com.example.ss12_th_bai2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "smartphone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Smartphone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String producer;

    private String model;

    private Double price;













}
