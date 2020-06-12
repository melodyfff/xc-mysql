package com.xinchen.orm.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;


/**
 * 注意版本对照： https://docs.spring.io/spring-data/elasticsearch/docs/4.0.0.RELEASE/reference/html/#preface.requirements
 *
 *
 * 较低版本的在使用{@link ElasticsearchRestTemplate} 如：
 * elasticsearchRestTemplate.query() , 可重写{@link ResultsExtractor},装填想要的结果 。 但是这里超过10000默认值时会报错
 *
 * elasticsearchRestTemplate.startScroll() 可重写{@link SearchResultMapper},封装想要的结果，这里没限制最大查询数
 *
 *
 *
 */
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }
}
