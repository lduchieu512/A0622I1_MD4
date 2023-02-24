package com.example.ss8_baitap.service;

import com.example.ss8_baitap.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    void create(User user);


}
