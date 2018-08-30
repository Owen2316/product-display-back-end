package com.ex.product.display.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


/**
 * @author owen
 */
@Entity
@Data
public class Category extends CommonColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 16, nullable = false)
    @NotEmpty(message = "name can not be empty!")
    private String name;

    public Category() { }

    public Category(User user, String name) {
        this.name = name;
        this.setModifier(user);
        this.setCreator(user);
    }

}
