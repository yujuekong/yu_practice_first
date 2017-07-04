package com.first.guice.ServletExtention;

import com.first.guice.module.JerseyModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class GuiceServletService extends GuiceServletContextListener{
    @Override
    protected Injector getInjector() {
        System.out.println("guiceServletService");
        return Guice.createInjector(new ServletModule(){
            @Override
            protected void configureServlets() {
                install(new JpaPersistModule("domain"));
                install(new JerseyModule());
                filter("/*").through(PersistFilter.class);
            }
        });
    }
}
