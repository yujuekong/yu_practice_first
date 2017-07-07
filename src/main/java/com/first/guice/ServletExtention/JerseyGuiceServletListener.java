package com.first.guice.ServletExtention;

import com.first.Jersey.GetPractice;
import com.first.Jersey.filter.ServletEncodingFilter;
import com.first.guice.module.ServiceModule;
import com.google.inject.Module;
import com.google.inject.persist.PersistFilter;
import com.google.inject.servlet.ServletModule;
import com.squarespace.jersey2.guice.JerseyGuiceServletContextListener;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujuekong on 2017/7/6.
 */
public class JerseyGuiceServletListener extends JerseyGuiceServletContextListener {
    @Override
    protected List<? extends Module> modules() {
        return Collections.singletonList(new ServletModule(){
            @Override
            protected void configureServlets() {
                install(new ServiceModule());
                //编码过滤器
                filter("/*").through(ServletEncodingFilter.class);
                //持久化过滤器，web程序必须的，代替了PersistService的start()初始化启动
                filter("/*").through(PersistFilter.class);

                Map<String,String> params = new HashMap<>();
                params.put("jersey.config.server.provider.packages", GetPractice.class.getPackage().getName());
                serve("/*").with(ServletContainer.class,params);
            }
        });
    }


}
