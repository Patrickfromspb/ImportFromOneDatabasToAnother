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



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.TimeZone;

/**
 * Точка входа в приложение. Подробнее
 * <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html"
 * >74.1 Create a deployable war file</a>.
 */


@SpringBootApplication
public class Application {


    protected Application() {
    }


    public static void main(final String[] args) throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
        DBJob dbJob=context.getBeanFactory().getBean(DBJob.class);
        int i;
        dbJob.init();
    }

}
