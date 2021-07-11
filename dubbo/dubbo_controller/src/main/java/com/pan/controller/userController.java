package com.pan.controller;


import com.pan.pojo.User;
import com.pan.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Reference
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
       return userService.findById(id);
    }

    @PostMapping
    public void save(User user) {
        userService.save(user);
    }

    @DeleteMapping
    public void delete(User user) {
        userService.delete(user);
    }
    @PutMapping
    public void updata(User user) {
        userService.updata(user);
    }
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
}
