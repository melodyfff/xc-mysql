package com.xinchen.orm.elasticsearch.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author xinchen
 * @version 1.0
 * @date 27/05/2020 16:19
 */
public interface LogInfoRepository extends ElasticsearchRepository<LogInfoEntity,Long> {
}
