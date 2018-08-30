package com.ex.product.display.repository;

import com.ex.product.display.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author owen
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
