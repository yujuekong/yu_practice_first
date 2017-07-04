package com.first.guice.module;

import com.first.Jersey.注解练习.GetPractice;
import com.first.guice.jpa.GuiceJpaService;
import com.first.guice.jpa.JpaInitializer;
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
        serve("/*").with(GuiceContainer.class, params);
    }
}
