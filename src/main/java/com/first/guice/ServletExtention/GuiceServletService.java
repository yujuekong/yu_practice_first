package com.first.guice.ServletExtention;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class GuiceServletService extends GuiceServletContextListener{
    @Override
    protected Injector getInjector() {
        System.out.println("guiceServletService");
        return Guice.createInjector(new ServletModule());
    }
}
