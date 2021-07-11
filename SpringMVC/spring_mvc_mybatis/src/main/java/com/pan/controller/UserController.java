package com.pan.controller;

import com.github.pagehelper.PageInfo;
import com.pan.domain.User;
import com.pan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Boolean save(User user){
        return userService.save(user);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable Integer uuid){
        return userService.delete(uuid);
    }

    @PutMapping
    public Boolean updata(User user){
        return userService.update(user);
    }

    @GetMapping("/{page}/{size}")
    public PageInfo<User> findAll(@PathVariable Integer page,@PathVariable Integer size){
        return userService.getAll(page,size);
    }

    @GetMapping("/{uuid}")
    public User get(@PathVariable Integer uuid){
        return userService.get(uuid);
    }

    @PostMapping("/login")
    public User login(@PathVariable String username,@PathVariable String password){
        return userService.login(username,password);
    }


}
