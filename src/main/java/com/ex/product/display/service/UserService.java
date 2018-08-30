package com.ex.product.display.service;

import com.ex.product.display.model.User;
import com.ex.product.display.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author owen
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getOne(Integer id){
        return userRepository.findById(id);
    }
}
