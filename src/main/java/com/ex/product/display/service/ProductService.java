package com.ex.product.display.service;

import com.ex.product.display.model.*;
import com.ex.product.display.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author owen
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private AttributeRepository attributeRepository;

    public List<Product> list(Product product){
        return productRepository.findAll(Example.of(product));
    }

    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    public Product save(Product product){
        Product result = null;
        User user = userRepository.findById(1).get();
        if(product.getId() != null && product.getId() !=0){
            result = productRepository.findById(product.getId()).get();
        }
        if(result == null){
            result = new Product();
            result.setCreator(user);
        }

        result.setName(product.getName());
        result.setDelete(product.isDelete());
        result.setDescription(product.getDescription());
        result.setOnSale(product.isOnSale());

        if(product.getCategory() != null && product.getCategory().getId() != null && product.getCategory().getId() != 0){
            Category category = categoryRepository.findById(product.getCategory().getId()).get();
            result.setCategory(category);
        }

        result.setModifier(user);
        result.setModifiedDate(new Date());

        result.getAttributes().clear();

        result = productRepository.save(result);

        for(ProductAttribute attr : product.getAttributes()){
            Attribute attribute = attributeRepository.findById(attr.getAttribute().getId()).get();
            ProductAttribute pa = new ProductAttribute(result,attribute,attr.getValue());

            productAttributeRepository.save(pa);
            result.getAttributes().add(pa);
        }

        return result;
    }
}
