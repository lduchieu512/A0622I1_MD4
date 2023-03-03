package com.example.ss9_baitap.aop;

import com.example.ss9_baitap.model.Book;
import com.example.ss9_baitap.model.Rent;
import com.example.ss9_baitap.service.IRentService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


@Aspect
@Configuration
public class AddRentAOP {

    @Autowired
    private IRentService rentService;

    Logger logger = LoggerFactory.getLogger(AddRentAOP.class);
//    src\main\resources\static\LogLibrary.txt
    String fileLibrary = "src\\main\\resources\\static\\LogLibrary.txt";
    String filePeople  = "src\\main\\resources\\static\\LogPeople.txt";
//    com/example/ss9_baitap/ss9_baitap/BookController.java
    @AfterReturning("execution(* com.example.ss9_baitap.controller.BookController.rentBook(..)) && args (id,..)")
    public void insertRentList(JoinPoint point, Long id){
        rentService.save(new Rent(getRandom(),"on",new Book(id)));
        logger.info("Time Taken by {} is {}",point, LocalDateTime.now());
        String text = String.format("Rent id Book %d where time is %s",id,LocalDateTime.now());
        writeLog(filePeople,text);
    }

    @AfterReturning("execution(* com.example.ss9_baitap.controller.BookController.returnBook(..)) && args (idReturn,..)")
    public void returnRentList(JoinPoint point,Long idReturn ){
        logger.info("Time Taken by {} is {}",point, LocalDateTime.now());
        String text = String.format("Return id rent book %d where time is %s",idReturn,LocalDateTime.now());
        writeLog(fileLibrary,text);

    }

    @AfterReturning("execution(* com.example.ss9_baitap.controller.*.*(..))")
    public void returnRentList(JoinPoint point){
        logger.info("Time Taken by {} is {}", point, LocalDateTime.now());
        String text = String.format("Time Taken by %s where time is %s", point, LocalDateTime.now());
        writeLog(fileLibrary,text);
    }










    private long getRandom() {
       return (long) ((Math.random()*(9999 - 10000))+10000);
    }
    public void writeLog(String link, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(link, true))) {
            bufferedWriter.write(text);
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
    }

















}
