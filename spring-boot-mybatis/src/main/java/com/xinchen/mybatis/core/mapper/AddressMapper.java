package com.xinchen.mybatis.core.mapper;

import com.xinchen.mybatis.core.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2022/7/17 16:01
 */
@Mapper
@Repository
public interface AddressMapper {
  @Results({
      @Result(id = true,column = "user_id",property = "userId"),
      @Result(column = "address",property = "address"),
  })
  @Select("Select * from app_address where user_id=#{userId}")
  Address getAddressByUserId(@Param("userId") Integer userId);
}
