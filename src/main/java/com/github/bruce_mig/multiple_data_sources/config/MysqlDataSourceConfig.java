package com.github.bruce_mig.multiple_data_sources.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration(proxyBeanMethods = false)
public class MysqlDataSourceConfig {


    @ConfigurationProperties("app.datasource.blog")
    @Bean
    public DataSourceProperties blogDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public HikariDataSource blogDataSource(DataSourceProperties blogDataSourceProperties) {
        return blogDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    /*@Bean
    DataSourceScriptDatabaseInitializer blogDataSourceScriptDatabaseInitializer(@Qualifier("blogDataSource") DataSource dataSource) {
        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:blog-schema.sql"));
        settings.setMode(DatabaseInitializationMode.NEVER);
        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }*/

}
