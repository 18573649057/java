package com.pan.dao;

import com.pan.domain.Admin;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDao {
    @Select("select * from Admin")
    List<Admin> findAll();

    @Update("update Admin set password = #{password} where username = #{username} ")
    void update(Admin admin);

    @Insert("insert into Admin(username,password)values(#{username},#{password})")
    void save(Admin admin);

    @Delete("delete from account where username = #{username} ")
    void delete(String username);
}
