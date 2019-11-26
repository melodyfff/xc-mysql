package com.xinchen.orm.jpa.core.repositories;

import com.xinchen.orm.jpa.core.entity.BaseData;
import org.springframework.data.repository.CrudRepository;

/**
 * @author xinchen
 * @version 1.0
 * @date 22/11/2019 10:54
 */
public interface BaseDataRepository extends CrudRepository<BaseData,Integer> {
}
