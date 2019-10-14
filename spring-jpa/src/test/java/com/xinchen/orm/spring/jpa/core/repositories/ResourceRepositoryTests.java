package com.xinchen.orm.spring.jpa.core.repositories;

import com.xinchen.orm.spring.jpa.AppTest;
import com.xinchen.orm.spring.jpa.core.domain.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author xinchen
 * @version 1.0
 * @date 14/10/2019 13:23
 */
@Slf4j
public class ResourceRepositoryTests extends AppTest {

    @Autowired
    private ResourceRepository resourceRepository;

    @Test
    public void testInsert(){
        Resource resource = new Resource();
        resource.setUrl("/admin");
        if (!resourceRepository.findById(1).isPresent()){
            resourceRepository.save(resource);
        }
    }

    @Test
    public void findResource(){
        System.out.println(resourceRepository.findById(1));
    }
}