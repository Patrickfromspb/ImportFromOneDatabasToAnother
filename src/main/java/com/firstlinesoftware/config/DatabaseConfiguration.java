
package com.firstlinesoftware.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Конфигурация взаимодействия БД.
 */
@Configuration
@EnableJpaAuditing
@EnableTransactionManagement
public class DatabaseConfiguration {
    @Bean
    public DataSource dataSource(
            @Value("${hikari.datasource-class-name}") final String datasourceClassName,
            @Value("${hikari.jdbc-url}") final String jdbcUrl,
            @Value("${hikari.username}") final String username,
            @Value("${hikari.password}") final String password,
            @Value("${hikari.maximum-pool-size}") final Integer maximumPoolSize,
            @Value("${hikari.leak-detection-threshold}") final Integer leakDetectionThreshold,
            @Value("${hikari.connection-timeout}") final Integer connectionTimeout) {
        final HikariConfig config = new HikariConfig();
        config.setDataSourceClassName(datasourceClassName);
        config.addDataSourceProperty("url", jdbcUrl);
        config.addDataSourceProperty("user", username);
        config.addDataSourceProperty("password", password);

        config.setMaximumPoolSize(maximumPoolSize);
        config.setLeakDetectionThreshold(leakDetectionThreshold);
        config.setConnectionTimeout(connectionTimeout);

        return new HikariDataSource(config);
    }
}
