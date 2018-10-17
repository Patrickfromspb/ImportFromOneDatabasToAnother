package com.firstlinesoftware;

import com.firstlinesoftware.entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
@Component
@ComponentScan("com.firstlinesoftware.config")
public class DBJob {
    @Autowired
    EntityManager entityManager;
    public void init(){
        Session session=entityManager.unwrap(Session.class);
        Transaction transaction=session.beginTransaction();
        transaction.begin();
        session.save(new User());
        transaction.commit();



    }
}
