package com.ex.product.display.repository;

import com.ex.product.display.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author owen
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
