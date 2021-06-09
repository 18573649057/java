package com.pan.Dao;

import com.pan.Bean.Student;
import com.pan.Servlet.getsql;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;


public interface selectStudentMapper {

    @Select("SELECT * FROM stu")
    public abstract List<Student> selectAll();

    @SelectProvider(type = getsql.class, method = "getselect")
    public abstract List<Student> selectBy(Student student) ;
}
