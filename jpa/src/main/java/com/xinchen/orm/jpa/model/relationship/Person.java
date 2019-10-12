package com.xinchen.orm.jpa.model.relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xinchen
 * @version 1.0
 * @date 11/10/2019 17:02
 */


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Person extends Base{
    private String firstName;
    private String lastName;

    /** 表明对应关系,此次测试可用不要 */
//    @ManyToOne()
//    private Family family;

    /** 标注不被持久化 */
    @Transient
    private String nonsenseField = "";

    @OneToMany
    private List<Job> jobList = new ArrayList<>();
}
