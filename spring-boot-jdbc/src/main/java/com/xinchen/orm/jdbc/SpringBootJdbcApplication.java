package com.xinchen.orm.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

import java.util.concurrent.CountDownLatch;

/**
 *
 */
@SpringBootApplication
@EnableJdbcRepositories
public class SpringBootJdbcApplication {

    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SpringBootJdbcApplication.class, args);

        latch.await();
    }

}
