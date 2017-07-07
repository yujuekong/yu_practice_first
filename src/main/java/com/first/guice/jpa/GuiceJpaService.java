package com.first.guice.jpa;

import com.first.domain.Message;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public String checkMessageName(String name){
        String respose = "";
        if(!Strings.isNullOrEmpty(name)){
           List<Message> messageList = entityManager.createQuery("from Message t where t.messageName=:name ")
                   .setParameter("name",name)
                   .getResultList();
           if(!messageList.isEmpty()){
               respose = "red:消息名称重复！";
           }else{
               respose = "blue:消息名称可用！";
           }
        }
        return respose;
    }
}
