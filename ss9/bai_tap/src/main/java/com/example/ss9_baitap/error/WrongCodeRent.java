package com.example.ss9_baitap.error;

public class WrongCodeRent extends Exception{
    public WrongCodeRent (String codeError){
        super(codeError);
    }
}
