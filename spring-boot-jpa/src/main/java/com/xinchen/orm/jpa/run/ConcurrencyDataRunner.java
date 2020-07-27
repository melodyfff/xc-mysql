package com.xinchen.orm.jpa.run;

import com.xinchen.orm.jpa.core.entity.ConcurrencyData;
import com.xinchen.orm.jpa.core.repositories.ConcurrencyDataRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程并发操作一列数据，保证唯一值
 *
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2020/5/5 13:06
 */
//@Component
public class ConcurrencyDataRunner implements CommandLineRunner {

    @Resource
    private ConcurrencyDataRepository repository;

    final static int SIZE = 1000;

    @Override
    public void run(String... args) throws Exception {
        final ConcurrencyData data = new ConcurrencyData();
        data.setId(1);
        data.setValue1(0);
        data.setValue2(0);
        data.setVersion(0);
        repository.save(data);

        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable task = () -> {
            final Optional<ConcurrencyData> byId = repository.findById(1);
            if (byId.isPresent()) {
                final ConcurrencyData concurrencyData = byId.get();
                final int value1 = concurrencyData.getValue1();
                final int value2 = concurrencyData.getValue2();
                concurrencyData.setValue1(value1 + 1);
                concurrencyData.setValue2(value2 + 1);
                repository.save(concurrencyData);
            }
        };
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(task);
        }


        TimeUnit.SECONDS.sleep(300);
        executorService.shutdown();
    }
}
