package com.xinchen.mybatis.core.web;

import com.xinchen.mybatis.core.dao.UserDao;
import com.xinchen.mybatis.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xinchen
 * @version 1.0
 * @date 16/01/2020 15:26
 */
@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping
    public List<User> all(){
        return userDao.queryAll();
    }
}
