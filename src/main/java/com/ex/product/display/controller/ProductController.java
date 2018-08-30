package com.ex.product.display.controller;

import com.ex.product.display.model.Category;
import com.ex.product.display.model.Product;
import com.ex.product.display.query.ProductQuery;
import com.ex.product.display.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

/**
 * @author owen
 */
@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> list(){
        return productService.list(ProductQuery.query());
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Integer id){
        Optional<Product> result = productService.findById(id);
        Product pro = result.get();
        System.out.println(pro);
        return result;
    }

    @PostMapping("/new")
    public Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product putProduct(@PathVariable Integer id, @RequestBody Product product){
        product.setId(id);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Integer id){
        Optional<Product> result = productService.findById(id);
        result.get().setDelete(true);
        return productService.save(result.get());

    }
}
