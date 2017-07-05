package com.first.guice.module;

import com.first.Jersey.GetPractice;
import com.first.guice.jpa.GuiceJpaService;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;

import static com.sun.jersey.api.core.PackagesResourceConfig.PROPERTY_PACKAGES;

/**
 * Created by yujuekong on 2017/7/4.
 */
public class JerseyModule extends JerseyServletModule {
    @Override
    protected void configureServlets() {

        bind(GuiceJpaService.class);
        bind(GetPractice.class);
        bind(GuiceContainer.class);

        Map<String, String> params = new HashMap<>();
        params.put(PROPERTY_PACKAGES, "com.first.Jersey");
        //这里控制jersey注解path的过滤，和指定jersey api所在的包（可以在web.xml中配置）
        serve("/*").with(GuiceContainer.class, params);
    }
}
