package com.xinchen.orm.jpa.model.relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
public class Family extends Base{
    private String description;

    @OneToMany(mappedBy = "family")
    private final List<Person> members = new ArrayList<>();
}

