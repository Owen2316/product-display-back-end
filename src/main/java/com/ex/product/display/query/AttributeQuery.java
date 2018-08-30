package com.ex.product.display.query;

import com.ex.product.display.model.Attribute;

/**
 * @author owen
 */
public class AttributeQuery {

    public static Attribute query(){
        Attribute attribute = new Attribute();
        attribute.setDelete(false);
        attribute.setModifiedDate(null);
        attribute.setCreatedDate(null);
        return attribute;
    }
}
