package com.pan.controller;

import com.pan.dao.BookDao;
import com.pan.service.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
    private BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        service aaa = (service)context.getBean("aaa");
        aaa.save();
        System.out.println();


        BookDao book = (BookDao) context.getBean("book");
        book.save();
    }
}
