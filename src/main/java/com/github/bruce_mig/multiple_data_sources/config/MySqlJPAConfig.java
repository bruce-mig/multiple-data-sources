package com.github.bruce_mig.multiple_data_sources.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.github.bruce_mig.multiple_data_sources.post",
        entityManagerFactoryRef = "mysqlEntityManagerFactoryBean",
        transactionManagerRef = "mysqlTransactionManager"
)
public class MySqlJPAConfig {

    @Bean
    LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder,
                                                                         @Qualifier("blogDataSource") DataSource dataSource) {
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.github.bruce_mig.multiple_data_sources.post")
                .build();
    }

    @Bean
    PlatformTransactionManager mysqlTransactionManager(
            @Qualifier("mysqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean emfb) {
        return new JpaTransactionManager(emfb.getObject());
    }
}
