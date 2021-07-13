package com.pan.dao;

import com.pan.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface Userdao {

    @Select("select * from userboot")
    public User findById(Integer id);

    @Insert("INSERT INTO userboot(id, username, password) VALUES (#{id}, #{username}, #{password});")
    public void save(User user);

    @Delete("delete * from userboot where id = #{id}")
    public void delete(User user);

    @Update("UPDATE userboot SET username = #{username}, password = #{password} WHERE id = #{id};")
    public void updata(User user);


    @Select("select * from userboot")
    public List<User> findAll();
}
