package com.xinchen.mybatis.core.dao;

import com.xinchen.mybatis.core.entity.User;

import java.util.List;

/**
 * @author xinchen
 * @version 1.0
 * @date 16/01/2020 14:43
 */
public interface UserDao {
    List<User> queryAll();
}
