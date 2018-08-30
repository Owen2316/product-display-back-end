package com.ex.product.display.init;

import com.ex.product.display.model.*;
import com.ex.product.display.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * @author owen
 */
@Component
@Order(value = 3)
public class InitProject implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private AttributeRepository attributeRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Override
    public void run(String... strings) throws Exception {
        logger.info(">>>>>>>>>>>>>>>>Init System>>>>>>>>>>>>>");
        if(userRepository.count() != 0){
            logger.info("System have be init");
        }else{
            User user = new User();
            user.setName("Admin");
            user.setCreator(user);
            user.setModifier(user);
            userRepository.save(user);

            Category category = new Category(user,"产品类别1");
            categoryRepository.save(category);
            Attribute attribute = new Attribute(user,"属性1");
            attributeRepository.save(attribute);
            Product product = new Product(user,"产品1","description",category);
            productRepository.save(product);
            ProductAttribute pa = new ProductAttribute(product,attribute,attribute.getName());
            productAttributeRepository.save(pa);



        }


    }
}
