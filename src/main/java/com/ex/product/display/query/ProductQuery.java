package com.ex.product.display.query;

import com.ex.product.display.model.Category;
import com.ex.product.display.model.Product;

/**
 * @author owen
 */
public class ProductQuery {

    public static Product query(){
        Product product = new Product();
        product.setDelete(false);
        product.setModifiedDate(null);
        product.setCreatedDate(null);
        return product;
    }
}
