package com.xinchen.orm.jpa.run;

import com.xinchen.orm.jpa.core.entity.BaseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * jpa批量插入实验
 *
 *
 * 关于批量处理的内存占用处理： https://www.baeldung.com/jpa-hibernate-batch-insert-update ： 4.2. Batch Insert with Explicit Flush
 *
 * Before transaction synchronization, Hibernate persistence context stores newly created entities and also the modified ones in memory.
 *
 * <p>EntityManager.flush()</p> also triggers a transaction synchronization
 *
 * Secondly the persistence context serves as an entity cache, thus also referred to as the first level cache.
 *
 * <p>EntityManager.clear()</p> To clear entities in the persistence context
 *
 *
 * @author xinchen
 * @version 1.0
 * @date 22/11/2019 10:55
 */
@Component
@Slf4j
public class BatchRunner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            if (i>0&&i%6==0){
                // triggers a transaction synchronization
                entityManager.flush();
                // To clear entities in the persistence context
                entityManager.clear();
            }
            BaseData baseData = new BaseData();
            baseData.setData("Hello - " + i);
            entityManager.persist(baseData);
        }

        // transaction not commit yet until now
        System.in.read();

        log.warn("{} : {} ms", "Total Cost", System.currentTimeMillis() - start);
    }
}
