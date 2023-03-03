package com.example.ss9_baitap.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String name;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private List<Rent> rentList;

    public Book(Long id) {
        this.id = id;
    }
}
