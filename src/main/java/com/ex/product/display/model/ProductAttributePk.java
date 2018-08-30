package com.ex.product.display.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author owen
 */
@Data
public class ProductAttributePk implements Serializable {
    private static final long serialVersionUID = -3064787073869760631L;
    private int product;

    private int attribute;

    public ProductAttributePk(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProductAttributePk that = (ProductAttributePk) o;
        return product == that.product &&
                attribute == that.attribute;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, attribute);
    }
}
