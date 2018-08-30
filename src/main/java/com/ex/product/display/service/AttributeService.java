package com.ex.product.display.service;

import com.ex.product.display.model.Attribute;
import com.ex.product.display.model.User;
import com.ex.product.display.repository.AttributeRepository;
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
public class AttributeService {
    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Attribute> list(Attribute attribute) {

        return attributeRepository.findAll(Example.of(attribute));
    }

    public Optional<Attribute> findById(Integer id) {
        return attributeRepository.findById(id);
    }

    public Attribute save(Attribute attr) {
        Attribute result = null;
        User user = userRepository.findById(1).get();
        if(attr.getId() != null && attr.getId() != 0){
            result = attributeRepository.findById(attr.getId()).get();
        }

        if(result == null){
            result = new Attribute();
            result.setCreator(user);
        }
        result.setName(attr.getName());
        result.setDelete(attr.isDelete());

        result.setModifier(user);
        result.setModifiedDate(new Date());

        return attributeRepository.save(result);
    }


}
