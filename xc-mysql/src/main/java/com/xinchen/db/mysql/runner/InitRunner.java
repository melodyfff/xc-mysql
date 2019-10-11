package com.xinchen.db.mysql.runner;

import com.xinchen.db.mysql.entity.User;
import com.xinchen.db.mysql.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 初始化自动插入数据
 *
 * @author xinchen
 * @version 1.0
 * @date 29/07/2019 08:44
 */
@Component
@Slf4j
public class InitRunner implements CommandLineRunner {

    private UserRepository userRepository;

    public InitRunner(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<User> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setUsername("user"+i);
            user.setPassword("123456");
            user.setName("no-"+i);
            list.add(user);
        }

        long begin = System.currentTimeMillis();

        userRepository.saveAll(list);
        log.warn("ALL INSERT DOWN , COST : {} ms",System.currentTimeMillis() - begin);
    }
}
