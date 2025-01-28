package com.github.bruce_mig.multiple_data_sources.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration(proxyBeanMethods = false)
public class MysqlDataSourceConfig {

    @Bean
    @ConfigurationProperties("app.datasource.blog")
    public DataSourceProperties blogDataSourceProperties() {
        return new DataSourceProperties();
    }

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
