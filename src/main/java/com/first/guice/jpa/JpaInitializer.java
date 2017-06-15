package com.first.guice.jpa;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class JpaInitializer {
    @Inject
    public JpaInitializer(PersistService service) {
        service.start();
    }
}
