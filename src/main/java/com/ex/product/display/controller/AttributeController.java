package com.ex.product.display.controller;

import com.ex.product.display.model.Attribute;
import com.ex.product.display.model.User;
import com.ex.product.display.query.AttributeQuery;
import com.ex.product.display.service.AttributeService;
import com.ex.product.display.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author owen
 */
@RestController
@RequestMapping("attributes")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Attribute> list(){
        return attributeService.list(AttributeQuery.query());
    }

    @PostMapping("/new")
    public Attribute save(@RequestBody Attribute attr){
        return attributeService.save(attr);
    }

    @GetMapping("/{id}")
    public Optional<Attribute> getAttribute(@PathVariable Integer id){
        return attributeService.findById(id);
    }

    @PutMapping("/{id}")
    public Attribute putAttribute(@PathVariable Integer id,@RequestBody Attribute attr){
        attr.setId(id);
        return attributeService.save(attr);
    }

    @DeleteMapping("/{id}")
    public Attribute deleteAttribute(@PathVariable Integer id){
        Attribute attr = attributeService.findById(id).get();
        attr.setDelete(true);
        return attributeService.save(attr);

    }


}
