package com.xinchen.mybatis.core.util;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xinchen
 * @version 1.0
 * @date 16/01/2020 16:46
 */
@Getter
@Setter
public class PageHelper {
    /**每页限制数,默认为5*/
    private int limit = 5;
    /**当前页偏移,默认为1*/
    private int offset = 1;
    /**排序*/
    private String order;
    /**排序列名称*/
    private String orderName;
    /**搜索内容*/
    private String search;
}
