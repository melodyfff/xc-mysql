package com.xinchen.mybatis.core.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 联系方式
 */
@Getter
@Setter
@ToString
public class Address implements Serializable {
  private int userId;
  private String address;
}
