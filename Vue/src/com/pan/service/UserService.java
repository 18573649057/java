package com.pan.service;

import com.pan.bean.User;

import java.io.IOException;
import java.util.List;
/*
    业务层约束接口
 */
public interface UserService {
    /*
        登录方法
     */
    public abstract List<User> login(User user) throws IOException;
}
