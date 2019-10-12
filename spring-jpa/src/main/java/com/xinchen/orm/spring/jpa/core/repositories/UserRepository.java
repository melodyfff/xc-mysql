package com.xinchen.orm.spring.jpa.core.repositories;

import com.xinchen.orm.spring.jpa.core.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author xinchen
 * @version 1.0
 * @date 12/10/2019 17:03
 */
public interface UserRepository extends CrudRepository<User,Integer> {
}
