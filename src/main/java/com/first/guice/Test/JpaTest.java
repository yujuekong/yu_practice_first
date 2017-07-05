package com.first.guice.Test;

import com.first.domain.Message;
import com.first.guice.jpa.GuiceJpaService;
import com.first.guice.jpa.JpaInitializer;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

/**
 * Created by yujuekong on 2017/6/14.
 */
public class JpaTest {
    public static void main(String[] args){
        Injector injector = Guice.createInjector(new JpaPersistModule("domain"));
        JpaInitializer jpaInitializer = injector.getInstance(JpaInitializer.class);
        GuiceJpaService jpaService = injector.getInstance(GuiceJpaService.class);
        Message message = jpaService.find("1");
        System.out.println(message.getMessageName());
//        Message newMessage = new Message("615","新消息","这是一条新的消息");
//        jpaService.saveMessage(newMessage);
    }
}
