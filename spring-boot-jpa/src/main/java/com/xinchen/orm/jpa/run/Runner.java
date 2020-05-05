package com.xinchen.orm.jpa.run;

import com.xinchen.orm.jpa.core.entity.BaseData;
import com.xinchen.orm.jpa.core.repositories.BaseDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * jpa批量插入实验
 *
 * @author xinchen
 * @version 1.0
 * @date 22/11/2019 10:55
 */
@Component
@Slf4j
public class Runner implements CommandLineRunner {
    @Resource
    private BaseDataRepository baseDataRepository;

    @Override
    public void run(String... args) throws Exception {
        final Optional<BaseData> byId = baseDataRepository.findById(1);
        if (!byId.isPresent()){
            long start = System.currentTimeMillis();
            List<BaseData> list = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                BaseData baseData = new BaseData();
                baseData.setData("Hello - " + i);
                list.add(baseData);
            }
            baseDataRepository.saveAll(list);
            log.warn("{} : {} ms", "Total Cost", System.currentTimeMillis() - start);
        }
    }
}
