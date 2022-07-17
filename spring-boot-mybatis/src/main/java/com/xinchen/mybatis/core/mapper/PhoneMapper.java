package com.xinchen.mybatis.core.mapper;

import com.xinchen.mybatis.core.entity.Phone;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
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
public interface PhoneMapper {
  @Results({
      @Result(id = true,column = "user_id",property = "userId"),
      @Result(column = "phone",property = "phone"),
  })
  @Select("Select * from app_phone where user_id=#{userId}")
  List<Phone> getByUserId(@Param("userId") Integer userId);
}
