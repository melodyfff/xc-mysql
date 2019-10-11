package com.xinchen.orm.jpa.model.relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * @author xinchen
 * @version 1.0
 * @date 11/10/2019 16:57
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Job extends Base{
    private double salery;
    private String jobDescr;
}
