package com.pan.Dao;
import com.pan.Bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class selectStudentDao {
    public static List<Student> selectAll() throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        selectStudentMapper mapper = sqlSession.getMapper(selectStudentMapper.class);
        List<Student> list = mapper.selectAll();
        return list;
    }
    public static List<Student> selectBy(Student student) throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        selectStudentMapper mapper = sqlSession.getMapper(selectStudentMapper.class);
        List<Student> students = mapper.selectBy(student);
        return students;
    }

}
