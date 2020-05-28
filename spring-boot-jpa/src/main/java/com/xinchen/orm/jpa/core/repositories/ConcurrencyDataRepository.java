package com.xinchen.orm.jpa.core.repositories;

import com.xinchen.orm.jpa.core.entity.ConcurrencyData;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2020/5/5 13:07
 */
public interface ConcurrencyDataRepository extends CrudRepository<ConcurrencyData,Integer> {
}
