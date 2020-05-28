package com.xinchen.orm.elasticsearch;

import com.xinchen.orm.elasticsearch.domain.LogInfoEntity;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;


/**
 *
 *
 * see: https://docs.spring.io/spring-data/elasticsearch/docs/4.0.0.RELEASE/reference/html/#elasticsearch.operations.usage
 *
 * 官方示例
 *
 * 请求新增：
 * curl -d '{"message": "ok667"}' -H "Content-Type: application/json" http://localhost:8080/loginfo
 *
 * 根据id查询
 * curl http://localhost:8080/loginfo/-567538613909940793
 *
 * @see ElasticsearchRestTemplate
 * @author xinchen
 * @version 1.0
 * @date 28/05/2020 15:05
 */
@RestController
@RequestMapping("/")
public class TestController {
    private final ElasticsearchOperations elasticsearchOperations;

    public TestController(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    @PostMapping("/loginfo")
    public ResponseEntity save(@RequestBody LogInfoEntity logInfoEntity){
        logInfoEntity.setId(ThreadLocalRandom.current().nextLong());
        logInfoEntity.setDate(new Date());
        IndexQuery indexQuery = new IndexQueryBuilder()
                .withId(String.valueOf(logInfoEntity.getId()))
                .withObject(logInfoEntity)
                .build();

        // Index an object. Will do save or update.
        final String documentId = elasticsearchOperations.index(indexQuery,
                elasticsearchOperations.getIndexCoordinatesFor(LogInfoEntity.class));
        return ResponseEntity.ok(documentId);
    }

    @GetMapping("/loginfo/{id}")
    public ResponseEntity findById(@PathVariable("id")  String id){
        final LogInfoEntity logInfoEntity = elasticsearchOperations.get(id, LogInfoEntity.class);
        return ResponseEntity.ok(logInfoEntity);
    }
}
