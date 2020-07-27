package com.xinchen.orm.elasticsearch;


import com.xinchen.orm.elasticsearch.domain.LogInfoEntity;
import com.xinchen.orm.elasticsearch.domain.LogInfoRepository;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author xinchen
 * @version 1.0
 * @date 27/05/2020 16:59
 */
public class LogInfoRepositoryTest extends SpringbootElasticsearchApplicationTests{
    @Resource
    private LogInfoRepository logInfoRepository;

    @Test
    public void test(){

        long id = 1234666;

        final LogInfoEntity logInfo = new LogInfoEntity();
        logInfo.setId(id);
        logInfo.setMessage("ok667");
        logInfo.setDate(new Date());

        logInfoRepository.save(logInfo);
        System.out.println(logInfoRepository.findById(id));
        System.out.println(logInfoRepository.findAll());
    }

}