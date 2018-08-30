package com.ex.product.display.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * @author owen
 */
@Entity
@IdClass(ProductAttributePk.class)
@Data
public class ProductAttribute {


    @Id
    @ManyToOne
    @JsonIgnoreProperties({"createdDate","modifiedDate","modifier","creator"})
    private Product product;

    @Id
    @ManyToOne
    @JsonIgnoreProperties({"createdDate","modifiedDate","modifier","creator"})
    private Attribute attribute;

    @Column(name="value")
    @NotEmpty(message = "value can not be empty!")
    private String value;

    public ProductAttribute(Product product, Attribute attribute, String value) {
        this.product = product;
        this.attribute = attribute;
        this.value = value;
    }

    public ProductAttribute(){}
}
