package com.xinchen.orm.elasticsearch.search;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 *
 * {@link Transient}                使用该注解可忽略field不进行存储
 *
 * {@link PersistenceConstructor}   使用该注解标记Constructor
 *
 * {@link TypeAlias}                标记_class中的民名称，默认为domain types class name
 *
 * @author xinchen
 * @version 1.0
 * @date 27/05/2020 16:19
 */
@Data
@TypeAlias("logInfo")
public class LogInfoEntityForSearch {
    @Id
    private String id;

    @Field(type = FieldType.Auto)
    private String message;

    /**
     * 注DateFormat.custom时，后面自定义的pattern才生效
     */
    @Field(type = FieldType.Date,format = DateFormat.basic_date_time,pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date date;
}
