package com.first.guice.jpa;

import com.first.domain.Message;
import com.google.inject.BindingAnnotation;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import javax.xml.ws.BindingType;


/**
 * Created by yujuekong on 2017/6/14.
 */
public class GuiceJpaService {

    @Inject
    private EntityManager entityManager;

    public Message find(){
        System.out.println("find");
        Message message = entityManager.find(Message.class,"1");
        return message;
    }

    @Transactional
    public void saveMessage(Message message){
        entityManager.persist(message);
    }
}
