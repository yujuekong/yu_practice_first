package com.first.guice.jpa;

import com.first.domain.Message;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


/**
 * Created by yujuekong on 2017/6/14.
 */
public class GuiceJpaService {

    @Inject
    private EntityManager entityManager;

    public Message find(String id){
        Message message = entityManager.find(Message.class,id);
        return message;
    }

    public List<Message> findAll(){
        List<Message> messageList = entityManager.createQuery("from Message").getResultList();
        return messageList;
    }

    @Transactional
    public void saveMessage(Message message){
        entityManager.persist(message);
    }
}
