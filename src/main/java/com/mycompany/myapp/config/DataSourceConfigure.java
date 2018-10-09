package com.mycompany.myapp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfigure {
    @Bean
    @ConfigurationProperties("spring.datasource.hikari")
    public HikariConfig config() {
        return new HikariConfig();
    }


    @Bean
    @RefreshScope
    public DataSource dataSource(DataSourceProperties dataSourceProperties, HikariConfig config) {
        HikariDataSource dataSource = dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class)
            .build();
        config.setDataSource(dataSource);
        return new HikariDataSource(config);
    }
}
