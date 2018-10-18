

package com.company.config;

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
