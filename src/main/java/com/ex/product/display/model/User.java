package com.ex.product.display.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * @author owen
 */
@Entity
@Data
public class User extends CommonColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(length = 50,nullable = false)
    private String name;
   }
