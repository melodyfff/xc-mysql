package com.xinchen.db.mysql.repository;

import com.xinchen.db.mysql.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author xinchen
 * @version 1.0
 * @date 29/07/2019 08:42
 */
public interface UserRepository extends CrudRepository<User,Long> {
}
