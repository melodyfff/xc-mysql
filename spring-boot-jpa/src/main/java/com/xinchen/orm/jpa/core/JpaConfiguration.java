package com.xinchen.orm.jpa.core;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

/**
 * @author xinchen
 * @version 1.0
 * @date 22/11/2019 11:00
 */

@EntityScan(basePackageClasses = JpaConfiguration.class)
@EnableJpaRepositories
@EnableTransactionManagement
@Configuration
public class JpaConfiguration {


    /**
     * PlatformTransactionManager
     * @param entityManagerFactory EntityManagerFactory
     * @return JpaTransactionManager
     */
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}
