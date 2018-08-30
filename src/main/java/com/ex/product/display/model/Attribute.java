package com.ex.product.display.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author owen
 */
@Entity
@Data
public class Attribute extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 16, nullable = false)
    @NotEmpty(message = "name can not be empty!")
    private String name;

    public Attribute() {
    }

    public Attribute(User user, String name) {
        this.name = name;
        this.setCreator(user);
        this.setModifier(user);
    }
}
