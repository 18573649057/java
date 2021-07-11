package com.pan.service.impl;


import com.pan.pojo.User;
import com.pan.dao.Userdao;
import com.pan.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Userdao userdao;

    public User findById(Integer id) {
        return userdao.findById(id);
    }

    public void save(User user) {
        userdao.save(user);
    }

    public void delete(User user) {
        userdao.delete(user);
    }

    public void updata(User user) {
        userdao.updata(user);
    }

    public List<User> findAll() {
        return userdao.findAll();
    }
}
