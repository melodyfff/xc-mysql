package com.xinchen.orm.jpa.run;

import com.xinchen.orm.jpa.core.entity.BaseData;
import com.xinchen.orm.jpa.core.repositories.BaseDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * jpa批量插入实验
 *
 * @author xinchen
 * @version 1.0
 * @date 22/11/2019 10:55
 */
@Component
@Slf4j
public class Runner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();
        List<BaseData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            BaseData baseData = new BaseData();
            baseData.setData("Hello - " + i);
            entityManager.persist(baseData);
        }
        entityManager.flush();
        log.warn("{} : {} ms", "Total Cost", System.currentTimeMillis() - start);
    }
}
