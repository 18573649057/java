package com.itheima.service;

import com.itheima.bean.User;

import java.util.List;

public interface UserService {
    public abstract List<User> login(User user);
}
