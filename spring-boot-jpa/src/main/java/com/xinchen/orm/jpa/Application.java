package com.xinchen.orm.jpa;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


/**
 *
 * springboot-jpa
 *
 * Batch insert/update reference: https://www.baeldung.com/jpa-hibernate-batch-insert-update
 *
 * Batch insert/update doesn't work? see: https://www.baeldung.com/jpa-hibernate-batch-insert-update - 7. @Id Generation Strategy
 *
 * 深坑： Entity的ID生成策略为 GenerationType.IDENTITY时，不能批处理
 *
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .run();
    }
}
