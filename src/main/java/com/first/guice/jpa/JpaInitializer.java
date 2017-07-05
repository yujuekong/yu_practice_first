package com.first.guice.jpa;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 * Created by yujuekong on 2017/6/14.
 * 此类在web应用中是无效的，因为persistFilter已做了同样的事情
 */
public class JpaInitializer {
    @Inject
    public JpaInitializer(PersistService service) {
        service.start();
    }
}
