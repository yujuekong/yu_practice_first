package com.first.mainTest;

import com.first.domain.Message;

import javax.persistence.*;
import java.util.List;

/**
 * Created by yujuekong on 2017/6/5.
 */
public class TestJPA {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static void main(String[] args){
        List<Message> messageList = TestJPA.getAllMesssage();
        System.out.print(messageList.size());
    }

    public static void saveMessage(String id,String name,String testNote){
        Message message = new Message(id,name,testNote);
        entityManager.persist(message);
    }

    public static List<Message> getAllMesssage(){
        return entityManager.createQuery("from Message ").getResultList();
    }
}
