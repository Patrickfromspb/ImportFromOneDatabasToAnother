package com.firstlinesoftware.db;

import com.firstlinesoftware.entities.User;
import com.firstlinesoftware.entities.User2;
import com.firstlinesoftware.entities.UserTable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        try (Writer writer = new FileWriter("Output3.json",true)) {
            Gson gson = new GsonBuilder().create();
            ScrollableResults itemCursor =
                    session.createQuery("from User").scroll();
            int count=0;
            while ( itemCursor.next() ) {
                User user = (User) itemCursor.get(0);
                gson.toJson(user, writer);
                writer.append(System.getProperty("line.separator"));
                if ( ++count % 100 == 0 ) {
                    session.flush();
                    session.clear();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done writing to file");
    }
    @Transactional
    public void readFromFile() {
        Session session = entityManager.unwrap(Session.class);

            try (BufferedReader br = Files.newBufferedReader(Paths.get("Output3.json"), StandardCharsets.UTF_8)) {
                for (String line = null; (line = br.readLine()) != null;) {
                    User2 user = new Gson().fromJson(line,User2.class);
                    System.out.println("USERRRRRR");
                    session.save(new UserTable(user));
                    session.flush();
                    session.clear();
                }
            System.out.println("Done reading from file");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
