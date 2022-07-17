package com.xinchen.mybatis.core.entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xinchen
 * @version 1.0
 * @date 16/01/2020 14:32
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private Address addresses;
    private List<Phone> phones;

}
