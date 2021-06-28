package com.pan.service.store;

import com.github.pagehelper.PageInfo;
import com.pan.domain.system.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    PageInfo findAll(int page,int size);

    User findById(String id);

    void delete(String id);

    void save(User user);

    void update(User user);
}
