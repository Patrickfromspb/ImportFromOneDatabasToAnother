package com.company.db;

import com.company.entities.TemporaryUser;
import com.company.entities.User;
import com.company.entities.User2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository

public  class  JobImpl implements Job {
    @Autowired
    EntityManager entityManager;
    @Autowired
    JobJPA jobJPA;
    @Transactional
    public synchronized void  init() {
    System.out.println("init just began");
        try {
            Session session = entityManager.unwrap(Session.class);
            for (int i = 0; i < 10; i++) {
                session.save(new User());
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        System.out.println("init just finished");

    }

    @Transactional
    public synchronized void saveToFile(String name, String filename ) {
        System.out.println("save to file just began");
        Session session = entityManager.unwrap(Session.class);
        try (Writer writer = new FileWriter("file",true)) {
            Gson gson = new GsonBuilder().create();
            ScrollableResults itemCursor =
                    session.createQuery("from "+name).scroll();
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
    public synchronized void readFromFile(String fileName) {
        System.out.println("read to file just began");
        Session session = entityManager.unwrap(Session.class);
            try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName), StandardCharsets.UTF_8)) {
                for (String line = null; (line = br.readLine()) != null;) {
                    TemporaryUser user = new Gson().fromJson(line,TemporaryUser.class);
                    session.save(new User2(user));
                    session.flush();
                    session.clear();
                }
            System.out.println("Done reading from file");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
