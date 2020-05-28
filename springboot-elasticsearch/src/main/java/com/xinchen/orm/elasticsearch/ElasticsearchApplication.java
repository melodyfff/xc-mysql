package com.xinchen.orm.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * 注意版本对照： https://docs.spring.io/spring-data/elasticsearch/docs/4.0.0.RELEASE/reference/html/#preface.requirements
 *
 */
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}
