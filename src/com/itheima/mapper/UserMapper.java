package com.itheima.mapper;

import com.itheima.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    public abstract List<User> login(User user);
}
