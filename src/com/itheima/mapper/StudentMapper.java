package com.itheima.mapper;

import com.itheima.bean.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface StudentMapper {



    @Select("SELECT * FROM student")
    public abstract List<Student> selectAll();




    @Insert("INSERT INTO student VALUES (#{number},#{name},#{birthday},#{address})")
    public abstract void addStu(Student stu);




    @Update("UPDATE student SET name=#{name},birthday=#{birthday},address=#{address} WHERE number=#{number}")
    public abstract void updateStu(Student stu);




    @Delete("DELETE FROM student WHERE number=#{number}")
    public abstract void deleteStu(String number);
}
