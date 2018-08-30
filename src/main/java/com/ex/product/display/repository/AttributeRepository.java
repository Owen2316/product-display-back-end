package com.ex.product.display.repository;

import com.ex.product.display.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author owen
 */
@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Integer> {
}
