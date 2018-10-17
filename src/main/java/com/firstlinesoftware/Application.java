/*
 * Copyright 2018 Russian Post
 *
 * This source code is Russian Post Confidential Proprietary.
 * This software is protected by copyright. All rights and titles are reserved.
 * You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 * Otherwise this violation would be treated by law and would be subject to legal prosecution.
 * Legal use of the software provides receipt of a license from the right holder only.
 */

package com.firstlinesoftware;

import com.firstlinesoftware.entities.User;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import javax.persistence.EntityManager;

import java.util.TimeZone;

/**
 * Точка входа в приложение. Подробнее
 * <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html"
 * >74.1 Create a deployable war file</a>.
 */

@ComponentScan("com.firstlinesoftware.config")
@SpringBootApplication
public class Application {

    @Autowired
    EntityManager entityManager;

    protected Application() {
    init();
    }
    public void init(){
        Session session=entityManager.unwrap(Session.class);
        Transaction transaction=session.beginTransaction();
        transaction.begin();
        session.save(new User());
        transaction.commit();



    }

    public static void main(final String[] args) throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(Application.class, args);
        new Application();

    }

}
