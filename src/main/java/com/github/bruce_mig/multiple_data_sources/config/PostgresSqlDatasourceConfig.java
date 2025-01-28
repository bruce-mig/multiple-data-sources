package com.github.bruce_mig.multiple_data_sources.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

@Configuration(proxyBeanMethods = false)
public class PostgresSqlDatasourceConfig {

    @Bean
    @ConfigurationProperties("app.datasource.subscribers")
    public DataSourceProperties subscribersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource subscriberDataSource(@Qualifier("subscribersDataSourceProperties") DataSourceProperties subscribersDataSourceProperties){
        return DataSourceBuilder
                .create()
                .url(subscribersDataSourceProperties.getUrl())
                .username(subscribersDataSourceProperties.getUsername())
                .password(subscribersDataSourceProperties.getPassword())
                .driverClassName(subscribersDataSourceProperties.getDriverClassName())
                .build();
    }

    /*@Bean
    DataSourceScriptDatabaseInitializer subscribeDataSourceScriptDatabaseInitializer(@Qualifier("subscriberDataSource") DataSource dataSource) {
        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:subscribers-schema.sql"));
        settings.setMode(DatabaseInitializationMode.NEVER);
        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }*/
}
