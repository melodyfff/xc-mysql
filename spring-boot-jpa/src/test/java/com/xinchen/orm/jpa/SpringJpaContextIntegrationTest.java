package com.xinchen.orm.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xinchen
 * @version 1.0
 * @date 08/06/2020 17:14
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = Application.class)
public class SpringJpaContextIntegrationTest {
    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
