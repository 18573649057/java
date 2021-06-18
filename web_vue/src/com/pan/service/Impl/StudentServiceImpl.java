package com.pan.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pan.bean.Student;
import com.pan.mapper.StudentMapper;
import com.pan.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentServiceImpl implements StudentService {
    @Override
    public Page selectByPage(Integer currentPage, Integer pageSize) throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Page page = PageHelper.startPage(currentPage, pageSize);
        mapper.selectAll();
        return page;
    }

    @Override
    public void addStu(Student stu) throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.addStu(stu);
    }

    @Override
    public void updateStu(Student stu) {

    }

    @Override
    public void deleteStu(String number) {

    }
}
