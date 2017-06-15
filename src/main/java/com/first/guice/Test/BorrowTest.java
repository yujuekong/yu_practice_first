package com.first.guice.Test;

import com.first.guice.module.ServiceModule;
import com.first.guice.service.BookStore;
import com.first.guice.service.BorrowInterfaceService;
import com.first.guice.service.BorrowService;
import com.first.guice.service.LoggeBuildInBindings;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class BorrowTest {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new ServiceModule());
        BorrowService borrowService = injector.getInstance(BorrowService.class);
        borrowService.borrow();
        BookStore bookStore = injector.getInstance(BookStore.class);
        bookStore.borrowBook();
        BorrowInterfaceService borrowInterfaceService = injector.getInstance(BorrowInterfaceService.class);
        borrowInterfaceService.borrow();
        LoggeBuildInBindings loggeBuildInBindings = injector.getInstance(LoggeBuildInBindings.class);
        loggeBuildInBindings.showLog();
    }
}
