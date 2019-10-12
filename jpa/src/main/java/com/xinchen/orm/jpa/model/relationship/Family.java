package com.xinchen.orm.jpa.model.relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author xinchen
 * @version 1.0
 * @date 11/10/2019 16:56
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table
public class Family extends Base{
    private String description;


    /**也可通过 @OneToMany(mappedBy = ) 指定,如果不加入@JoinColumn则会新生成一张表*/
    @OneToMany
    @JoinColumn(name="family_id")
    private final List<Person> members = new ArrayList<>();
}

