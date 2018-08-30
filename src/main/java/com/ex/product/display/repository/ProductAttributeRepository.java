package com.ex.product.display.repository;

import com.ex.product.display.model.ProductAttribute;
import com.ex.product.display.model.ProductAttributePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author owen
 */
@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute,ProductAttributePk> {
}
