package com.xinchen.orm.spring.jpa.core.repositories;

import com.xinchen.orm.spring.jpa.core.domain.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * @author xinchen
 * @version 1.0
 * @date 14/10/2019 11:09
 */
public interface RoleRepository extends CrudRepository<Role,Integer> {
}
