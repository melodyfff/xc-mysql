package com.xinchen.orm.spring.jpa.core.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * 如果是在spring中可以使用@CreatedDate和@LastModifiedDate
 *
 * @author xinchen
 * @version 1.0
 * @date 12/10/2019 14:48
 */
@Entity
@Table(name = "app_user")
@Data
@EqualsAndHashCode(callSuper=true)
public class User extends Base{

    @Column(name = "user_name",nullable = false)
    private String userName;

    @Column(name = "password",nullable = false)
    private String password;


    @OneToMany(cascade = {CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Role> roles = new ArrayList<>();


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time")
    private Date updateTime;
}
