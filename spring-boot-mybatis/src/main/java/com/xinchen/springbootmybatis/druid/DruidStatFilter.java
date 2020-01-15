package com.xinchen.springbootmybatis.druid;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author xinchen
 * @version 1.0
 * @date 15/01/2020 16:37
 */
@WebFilter(filterName="druidWebStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") //忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter {
}
