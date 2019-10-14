package com.xinchen.orm.spring.jpa.core.repositories;

import com.xinchen.orm.spring.jpa.AppTest;
import com.xinchen.orm.spring.jpa.core.domain.Resource;
import com.xinchen.orm.spring.jpa.core.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;


/**
 * @author xinchen
 * @version 1.0
 * @date 14/10/2019 13:23
 */
@Slf4j
public class RoleRepositoryTests extends AppTest {
    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void testInsert(){

        Resource resource = resourceRepository.findById(1).orElse(null);
        Assert.notNull(resource,"请先插入resource");

        Role role = new Role();
        role.setRoleName("管理员");
        role.getResources().add(resource);

        Role role1 = new Role();
        role1.setRoleName("用户");
        role1.getResources().add(resource);

        if (!roleRepository.findById(1).isPresent()){
            roleRepository.save(role);
        }

        if (!roleRepository.findById(2).isPresent()){
            roleRepository.save(role1);
        }
    }

    @Test
    @Transactional
    public void testFind(){
        System.out.println(roleRepository.findById(1));
        System.out.println(roleRepository.findById(2));
    }

    @Test
    public void testDelete(){
        final Optional<Role> role = roleRepository.findById(2);
        role.ifPresent(value -> roleRepository.delete(value));
    }
}