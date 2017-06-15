package com.first.guice.service;

import com.google.inject.Inject;

/**
 * Created by yujuekong on 2017/6/14.
 * 这是一个根据自定义注解来注入的例子
 */
public class BorrowInterfaceService {
    private BookStore bookStore;

    @Inject
    public BorrowInterfaceService(@Borrow2Interface BookStore bookStore) {
        this.bookStore = bookStore;
    }

    public void borrow(){
        bookStore.borrowBook();
    }

    public BookStore getBookStore() {
        return bookStore;
    }

    public void setBookStore(BookStore bookStore) {
        this.bookStore = bookStore;
    }
}
