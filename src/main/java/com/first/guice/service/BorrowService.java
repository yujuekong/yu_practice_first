package com.first.guice.service;

import com.google.inject.Inject;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class BorrowService {

    private BookStore bookStore;

    @Inject
    public BorrowService(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    public void borrow(){
        bookStore.borrowBook();
    }

}
