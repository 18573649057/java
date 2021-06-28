package com.pan.Dao.store;

import com.pan.domain.system.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(String id);

    int delete(String id);

    int save(User user);

    int update(User user);
}
