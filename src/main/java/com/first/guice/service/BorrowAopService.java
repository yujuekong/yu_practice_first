package com.first.guice.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class BorrowAopService implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Method method = invocation.getMethod();
        System.out.println("这里是AOP拦截的信息:"+ method.getName());
        return invocation.proceed();
    }

}
