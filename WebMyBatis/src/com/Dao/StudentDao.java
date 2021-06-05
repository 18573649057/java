package com.Dao;

import com.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public static ArrayList<Student> findAll() throws Exception{
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        List<Student> students = sqlSessionFactory.openSession(true).selectList("Mapper.findAll");
        return (ArrayList<Student>) students;

    }

}
