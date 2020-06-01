package com.xinchen.orm.elasticsearch.search;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.util.CloseableIterator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * 用filebeat推送数据到es后，根据index进行查询操作
 *
 * 官网文档： https://docs.spring.io/spring-data/elasticsearch/docs/4.0.0.RELEASE/reference/html/#elasticsearch.scroll
 *
 * @author xinchen
 * @version 1.0
 * @date 01/06/2020 13:44
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    private final ElasticsearchRestTemplate elasticsearchRestTemplate;


    public SearchController(ElasticsearchRestTemplate elasticsearchRestTemplate) {
        this.elasticsearchRestTemplate = elasticsearchRestTemplate;
    }


    @GetMapping("/{index}")
    public ResponseEntity findByIndex(@PathVariable("index")  String index){

        final IndexCoordinates indexCoordinates = IndexCoordinates.of(index);

        final NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchAllQuery())
                .withFields("message")
                .withPageable(PageRequest.of(0, 100))
                .build();

        final CloseableIterator<LogInfoEntityForSearch> stream = elasticsearchRestTemplate.stream(nativeSearchQuery,
                LogInfoEntityForSearch.class,
                indexCoordinates);


        return ResponseEntity.ok(stream);
    }
}
