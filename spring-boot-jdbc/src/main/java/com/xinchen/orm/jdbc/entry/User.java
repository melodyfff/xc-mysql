package com.xinchen.orm.jdbc.entry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author xinchen
 * @version 1.0
 * @date 15/01/2020 15:24
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private long id;

    private String userName;

    private String password;
}