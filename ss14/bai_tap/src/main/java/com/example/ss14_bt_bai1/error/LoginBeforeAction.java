package com.example.ss14_bt_bai1.error;

public class LoginBeforeAction extends Exception{
    public LoginBeforeAction(String error){
        super(error);
    }
}
