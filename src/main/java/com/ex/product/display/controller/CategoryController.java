package com.ex.product.display.controller;

import com.ex.product.display.model.Category;
import com.ex.product.display.model.User;
import com.ex.product.display.query.CategoryQuery;
import com.ex.product.display.service.CategoryService;
import com.ex.product.display.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author owen
 */
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Category> list(){
        return categoryService.list(CategoryQuery.query());
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable Integer id){
        return categoryService.findById(id);
    }

    @PostMapping("/new")
    public Category postCategory(@RequestBody Category category){
        System.out.println(category);
        return categoryService.save(category);

    }

    @PutMapping("/{id}")
    public Category putCategory(@PathVariable Integer id,@RequestBody Category category){
        category.setId(id);
        return categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public Category deleteCategory(@PathVariable Integer id){
        Optional<Category> result = categoryService.findById(id);
        result.get().setDelete(true);
        return categoryService.save(result.get());

    }
}
