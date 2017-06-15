package com.first.mainTest;

import com.first.domain.Message;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by yujuekong on 2017/6/5.
 */
public class TestJPA {
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static void main(String[] args){
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("domain");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        Message message = new Message("1","测试","测试信息");
//        entityManager.persist(message);
//        entityTransaction.commit();
//        entityManager.close();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        TestJPA.saveMessage("2","测试2","测试测试2");
//        entityTransaction.commit();
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
