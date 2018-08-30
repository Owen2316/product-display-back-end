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
@Data
@Entity
public class Product extends CommonColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    @NotEmpty(message = "name can not be empty!")
    private String name;

    @Column(length = 1000)
    private String description;

    @Column(name = "onSale", columnDefinition = "int(1) not null default 0")
    @JsonIgnore
    protected int onSaleValue = 1;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,orphanRemoval = true)
    @JsonIgnoreProperties({"product"})
    private List<ProductAttribute> attributes = new ArrayList<ProductAttribute>();

    @ManyToOne()
    @JoinColumn(name = "category")
    @JsonIgnoreProperties({"createdDate","modifiedDate","modifier","creator"})
    private Category category;

    public boolean isOnSale() {
        return this.getOnSaleValue() == 1;
    }

    public void setOnSale(boolean onSale) {
        this.setOnSaleValue(onSale ? 1 : 0);
    }

    public Product(){

    }

    public Product(User user, String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.setCreator(user);
        this.setModifier(user);
    }
}
