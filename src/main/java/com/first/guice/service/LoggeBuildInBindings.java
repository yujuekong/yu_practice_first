package com.first.guice.service;

import com.google.inject.Inject;

import java.util.logging.Logger;

/**
 * Created by yujuekong on 2017/6/14.
 * Injector内置绑定
 */
public class LoggeBuildInBindings {

    private Logger logger;

    @Inject
    public LoggeBuildInBindings(Logger logger) {
        this.logger = logger;
    }

    @GuiceAopInterface
    public void showLog(){
        logger.warning("这是一条内置Logger的警告信息！");
    }
}
