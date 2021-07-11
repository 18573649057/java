package com.pan.service;

import com.github.pagehelper.PageInfo;
import com.pan.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UserService {

    @Transactional(readOnly = false)
    public boolean save(User user);

    @Transactional(readOnly = false)
    public boolean update(User user);

    @Transactional(readOnly = false)
    public boolean delete(Integer uuid);

    public User get(Integer uuid);

    public PageInfo<User> getAll(int page, int size);

    public User login(@Param("userName") String userName, @Param("password") String password);
}
