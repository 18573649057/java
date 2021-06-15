package com.pan.mapper;

import com.pan.bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /*
        登录方法
     */
    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    public abstract List<User> login(User user);
}
