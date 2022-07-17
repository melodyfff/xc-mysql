package com.xinchen.mybatis.run;

import com.xinchen.mybatis.core.dao.UserDao;
import com.xinchen.mybatis.core.mapper.UserMapper;
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
    private final UserMapper userMapper;

    public MybatisRunTest(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        final PageHelper pageHelper = new PageHelper();
        while (true){
            System.out.println("传统xml查询："+userDao.queryAll());
            System.out.println("注解查询："+userMapper.getUsers());
            System.out.println("注解查询："+userMapper.getUser2());
            System.out.println("注解查询："+userMapper.getAll());
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
