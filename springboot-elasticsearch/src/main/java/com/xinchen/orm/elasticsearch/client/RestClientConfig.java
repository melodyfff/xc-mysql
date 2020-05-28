package com.xinchen.orm.elasticsearch.client;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.convert.ElasticsearchCustomConversions;

/**
 *
 * 官方推荐配置： https://docs.spring.io/spring-data/elasticsearch/docs/4.0.0.RELEASE/reference/html/#elasticsearch.clients.rest
 *
 * {@link TransportClient} is deprecated as of Elasticsearch 7 and will be removed in Elasticsearch 8.
 *
 *
 * @author xinchen
 * @version 1.0
 * @date 27/05/2020 16:29
 */
@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration = ClientConfiguration
                .builder()
                .connectedTo("127.0.0.1:9200")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }


    @Override
    public ElasticsearchCustomConversions elasticsearchCustomConversions() {
        // 自定义转换
        // https://docs.spring.io/spring-data/elasticsearch/docs/4.0.0.RELEASE/reference/html/#elasticsearch.mapping.meta-model.conversions
        return super.elasticsearchCustomConversions();
    }
}
