package com.xinchen.orm.jpa.core.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author Xin Chen (xinchenmelody@gmail.com)
 * @version 1.0
 * @date Created In 2020/5/5 13:02
 */
@Entity
@Data
@Table(name = "base_concurrency_data")
public class ConcurrencyData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "value1")
    private int value1;
    @Column(name = "value2")
    private int value2;

    @Version
    private int version;
}
