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
 * 由于选择其他策略如： GenerationType.SEQUENCE 每次都会去数据库查询和同步，如果遇到数据库访问慢的，会很耗时间，解决方案：
 * Hibernate入门之主键生成策略详解： https://www.cnblogs.com/CreateMyself/p/12378362.html
 * <P>
 *     @GeneratedValue(strategy = GenerationType.AUTO,generator = "base_data_test_generator")
 *     @SequenceGenerator(name = "base_data_test_generator",sequenceName = "base_data_test_seq", allocationSize = 10)
 * </P>
 *
 * allocationSize存储于内存中，减少与数据库的交互
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
