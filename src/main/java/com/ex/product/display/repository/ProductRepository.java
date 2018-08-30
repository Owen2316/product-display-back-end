package com.ex.product.display.repository;

import com.ex.product.display.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author owen
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
