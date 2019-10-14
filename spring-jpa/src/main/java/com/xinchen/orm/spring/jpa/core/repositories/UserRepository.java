package com.xinchen.orm.spring.jpa.core.repositories;

import com.xinchen.orm.spring.jpa.core.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @author xinchen
 * @version 1.0
 * @date 12/10/2019 17:03
 */
public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByCreateTimeBefore(Date date);
}
