package com.firstlinesoftware.db;

import com.firstlinesoftware.entities.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Repository
public class JobImpl implements Job {
    @Autowired
    EntityManager entityManager;
    @Autowired
    JobJPA jobJPA;

    @Transactional
    public void init() {

        try {
            Session session = entityManager.unwrap(Session.class);
            for (int i = 0; i < 10; i++) {
                session.save(new User());
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    @Transactional
    public void saveToFile() {
        Session session = entityManager.unwrap(Session.class);
        List<User> users = jobJPA.findAll();
        try (Writer writer = new FileWriter("Output.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
