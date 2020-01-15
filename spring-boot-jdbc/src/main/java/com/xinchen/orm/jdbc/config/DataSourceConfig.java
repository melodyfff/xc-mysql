package com.xinchen.orm.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author xinchen
 * @version 1.0
 * @date 15/01/2020 15:16
 */
@Configuration
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .ignoreFailedDrops(true)
                .addScript("classpath:init/h2/app_user.sql")
                .build();
    }
}
