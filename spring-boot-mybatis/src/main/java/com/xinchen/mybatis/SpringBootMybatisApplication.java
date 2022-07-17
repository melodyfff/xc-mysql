package com.xinchen.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 访问 /druid查看监控
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.xinchen.mybatis.core.dao","com.xinchen.mybatis.core.mapper"})
public class SpringBootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

}
