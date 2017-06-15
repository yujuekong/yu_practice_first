package com.first.guice.module;

import com.first.guice.service.*;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class ServiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(BookStore.class).to(BookBorrowImp.class);
        bind(BookStore.class).annotatedWith(Borrow2Interface.class).to(BookBorrowImp2.class);
        bindInterceptor(Matchers.any(),Matchers.annotatedWith(GuiceAopInterface.class),new BorrowAopService());
    }

}
