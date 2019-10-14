package com.xinchen.orm.spring.jpa.core.repositories;

import com.xinchen.orm.spring.jpa.AppTest;
import com.xinchen.orm.spring.jpa.core.domain.Role;
import com.xinchen.orm.spring.jpa.core.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


/**
 * @author xinchen
 * @version 1.0
 * @date 12/10/2019 17:06
 */
@Slf4j
public class UserRepositoryTests extends AppTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void testInsert(){
        final Optional<Role> role = roleRepository.findById(1);
        Assert.assertNotNull(role.orElse(null));

        final Optional<Role> role2 = roleRepository.findById(2);
        Assert.assertNotNull(role2.orElse(null));

        User user = new User();
        user.setUserName("admin");
        user.setPassword("admin");
        user.getRoles().add(role.get());

        User user1 = new User();
        user1.setUserName("user");
        user1.setPassword("user");
        user1.getRoles().add(role2.get());



        if (!userRepository.findById(1).isPresent()){
            userRepository.save(user);
        }

        if (!userRepository.findById(2).isPresent()){
            userRepository.save(user1);
        }

    }

    @Test
    @Transactional
    public void find(){
        log.info(">>> "+userRepository.findById(1).orElse(null));
        log.info(">>> "+userRepository.findById(2).orElse(null));
    }


    @Test
    public void testDelete(){
        userRepository.findById(2).ifPresent(user -> userRepository.delete(user));
    }

}