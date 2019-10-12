package com.xinchen.orm.spring.jpa.core.repositories;

import com.xinchen.orm.spring.jpa.config.AppConfig;
import com.xinchen.orm.spring.jpa.config.JpaConfiguration;
import com.xinchen.orm.spring.jpa.core.domain.Resource;
import com.xinchen.orm.spring.jpa.core.domain.Role;
import com.xinchen.orm.spring.jpa.core.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


/**
 * @author xinchen
 * @version 1.0
 * @date 12/10/2019 17:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = {AppConfig.class})
})
@Transactional
@Slf4j
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;


    @Before

    public void setUp(){
        Resource resource = new Resource();
        resource.setUrl("/admin");

        Role role = new Role();
        role.setRoleName("管理员");
        role.getResources().add(resource);

        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        user.setCreateTime(new Date());
        user.getRoles().add(role);

        userRepository.save(user);
    }

    @Test
    public void find(){
        final Optional<User> user = userRepository.findById(1);
        log.info(">>> "+user.orElse(null));
    }

}