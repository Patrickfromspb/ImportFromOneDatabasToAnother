package com.firstlinesoftware;

import com.firstlinesoftware.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component

public class DBJob {
    @Autowired

    EntityManager entityManager;
    @Transactional
    public void init(){
        Transaction transaction=null;
       try{
         Session session=entityManager.unwrap(Session.class);
         transaction=session.beginTransaction();
        transaction.begin();
        session.save(new User());
        transaction.commit();

    } catch (Exception ex) {
        ex.printStackTrace();
        transaction.rollback();
       }


    }
}
