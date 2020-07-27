package com.xinchen.orm.elasticsearch;

import com.google.gson.Gson;
import com.xinchen.orm.elasticsearch.domain.LogInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * 打印日志方便通过filebeat推送到es
 *
 * @author xinchen
 * @version 1.0
 * @date 01/06/2020 09:51
 */
@Slf4j
//@Component
public class InitRunner implements CommandLineRunner {
    private static final Gson gson = new Gson();

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 100; i++) {
            LogInfoEntity logInfoEntity = new LogInfoEntity();
            logInfoEntity.setId(ThreadLocalRandom.current().nextLong());
            logInfoEntity.setDate(new Date());
            logInfoEntity.setMessage("ok: "+System.currentTimeMillis());
            log.info("{}",gson.toJson(logInfoEntity));
        }
    }
}
