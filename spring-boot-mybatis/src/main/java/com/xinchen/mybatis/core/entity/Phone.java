package com.xinchen.mybatis.core.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 */
@Setter
@Getter
@ToString
public class Phone implements Serializable {
  private int userId;
  private String phone;
}
