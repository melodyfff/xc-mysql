package com.xinchen.orm.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 *
 * springboot-jpa
 *
 * Batch insert/update reference: https://www.baeldung.com/jpa-hibernate-batch-insert-update
 *
 */
@SpringBootApplication
@EntityScan("com.xinchen.orm.jpa.core.entity")
@EnableJpaRepositories
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
