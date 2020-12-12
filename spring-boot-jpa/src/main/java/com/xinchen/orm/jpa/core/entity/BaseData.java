package com.xinchen.orm.jpa.core.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author xinchen
 * @version 1.0
 * @date 22/11/2019 10:48
 */
@Entity
@Data
@Table(name = "base_data_test")
public class BaseData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "base_data_test_generator")
    @SequenceGenerator(name = "base_data_test_generator",sequenceName = "base_data_test_seq", allocationSize = 10)
    private int id;

    @Column(name = "data")
    private String data;
}
