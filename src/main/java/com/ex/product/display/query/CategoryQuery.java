package com.ex.product.display.query;

import com.ex.product.display.model.Category;

/**
 * @author owen
 */
public class CategoryQuery {

    public static Category query(){
        Category category = new Category();
        category.setDelete(false);
        category.setModifiedDate(null);
        category.setCreatedDate(null);
        return category;
    }
}
