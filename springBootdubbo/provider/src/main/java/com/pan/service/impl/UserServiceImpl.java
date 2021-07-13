package com.pan.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pan.dao.Userdao;
import com.pan.domain.User;
import com.pan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private Userdao userdao;

    @Override
    public User findById(Integer id) {
        return userdao.findById(id);
    }

    @Override
    public void save(User user) {
        userdao.save(user);
    }

    @Override
    public void delete(User user) {
        userdao.delete(user);
    }

    @Override
    public void updata(User user) {
        userdao.updata(user);
    }

    @Override
    public List<User> findAll() {
        return userdao.findAll();
    }
}
