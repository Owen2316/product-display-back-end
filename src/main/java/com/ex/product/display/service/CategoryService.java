package com.ex.product.display.service;

import com.ex.product.display.model.Category;
import com.ex.product.display.model.User;
import com.ex.product.display.query.CategoryQuery;
import com.ex.product.display.repository.CategoryRepository;
import com.ex.product.display.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author owen
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Category> list(Category category) {
        return categoryRepository.findAll(Example.of(category));
    }

    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category save(Category category) {
        Category result = null;
        User user = userRepository.findById(1).get();
        if(category.getId() != null && category.getId() !=0){
            result = categoryRepository.findById(category.getId()).get();
        }
        if(result == null){
            result = new Category();
            result.setCreator(user);
        }

        result.setName(category.getName());
        result.setDelete(category.isDelete());

        result.setModifier(user);
        result.setModifiedDate(new Date());

        return categoryRepository.save(result);
    }
}
