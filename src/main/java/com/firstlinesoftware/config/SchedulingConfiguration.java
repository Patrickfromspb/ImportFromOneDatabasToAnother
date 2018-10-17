/*
 * Copyright 2018 Russian Post
 *
 *  This source code is Russian Post Confidential Proprietary.
 *  This software is protected by copyright. All rights and titles are reserved.
 *  You shall not use, copy, distribute, modify, decompile, disassemble or reverse engineer the software.
 *  Otherwise this violation would be treated by law and would be subject to legal prosecution.
 *  Legal use of the software provides receipt of a license from the right holder only.
 */

package com.firstlinesoftware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;

import java.util.concurrent.ExecutorService;

@Configuration
@EnableScheduling
class SchedulingConfiguration {

    @Bean
    public TaskScheduler taskScheduler(final ExecutorService executorService) {
        final ConcurrentTaskScheduler taskScheduler = new ConcurrentTaskScheduler();
        taskScheduler.setConcurrentExecutor(executorService);
        return taskScheduler;
    }
}
