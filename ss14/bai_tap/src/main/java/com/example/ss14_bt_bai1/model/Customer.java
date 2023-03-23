package com.example.ss14_bt_bai1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer",uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UK",columnNames = "username")})
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Column(name = "enabled",length = 1,nullable = false)
    private Boolean enabled;





}
