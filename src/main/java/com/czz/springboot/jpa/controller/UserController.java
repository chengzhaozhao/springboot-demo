package com.czz.springboot.jpa.controller;

import com.czz.springboot.jpa.domain.User;
import com.czz.springboot.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-20 10:14
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userRepository.getOne(id);
    }

    @GetMapping(value = "/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return save;
    }
}
