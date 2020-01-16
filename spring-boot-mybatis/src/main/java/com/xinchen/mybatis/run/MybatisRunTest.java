package com.xinchen.mybatis.run;

import com.xinchen.mybatis.core.dao.UserDao;
import com.xinchen.mybatis.core.util.PageHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xinchen
 * @version 1.0
 * @date 16/01/2020 14:48
 */
@Component
public class MybatisRunTest implements CommandLineRunner {

    private final UserDao userDao;

    public MybatisRunTest(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {
        final PageHelper pageHelper = new PageHelper();
        while (true){
            System.out.println(userDao.queryAll());
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
