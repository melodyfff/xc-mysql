package com.xinchen.orm.jpa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @Entity 中的`name`指定 select * from ? 这里的?的名称
 * @author xinchen
 * @version 1.0
 * @date 11/10/2019 15:37
 */
@Entity(name = "Todo")
@Table(name = "app_todo")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** 默认会有@Column */
    @Column(name = "summary")
    private String summary;
    private String description;
}
