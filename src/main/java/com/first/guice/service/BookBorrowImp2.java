package com.first.guice.service;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class BookBorrowImp2 implements BookStore{
    public void borrowBook() {
        System.out.println("我借了一本关于Java的书籍！");
    }
}
