package com.first.guice.module;

import com.first.Jersey.GetPractice;
import com.first.guice.jpa.GuiceJpaService;
import com.first.guice.service.*;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.matcher.Matchers;
import com.google.inject.persist.jpa.JpaPersistModule;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class ServiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(BookStore.class).to(BookBorrowImp.class);
        bind(BookStore.class).annotatedWith(Borrow2Interface.class).to(BookBorrowImp2.class);
        bindInterceptor(Matchers.any(),Matchers.annotatedWith(GuiceAopInterface.class),new BorrowAopService());
        bind(GuiceJpaService.class);
        bind(GetPractice.class);
        bind(ServletContainer.class).in(Singleton.class);
        //启动jpa持久化配置
        install(new JpaPersistModule("domain"));
    }

}
