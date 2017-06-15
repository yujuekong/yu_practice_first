package com.first.guice.service;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class BookBorrowImp implements BookStore{
    @Override
    public void borrowBook() {
        System.out.println("我借了一本关于Guice依赖注入的书籍！");
    }
}
