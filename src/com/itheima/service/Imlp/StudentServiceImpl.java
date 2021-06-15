package com.itheima.service.Imlp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class StudentServiceImpl implements StudentService {

    @Override
    public Page selectByPage(Integer currentPage, Integer pageSize) {
        InputStream is = null;
        SqlSession sqlSession = null;
        Page page = null;
        try {

            is = Resources.getResourceAsStream("mybatisConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            sqlSession = sqlSessionFactory.openSession(true);

            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            page = PageHelper.startPage(currentPage, pageSize);

            mapper.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //8.返回结果到控制层
        return page;
    }

    @Override
    public void addStu(Student stu) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            sqlSession = sqlSessionFactory.openSession(true);

            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            mapper.addStu(stu);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateStu(Student stu) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            sqlSession = sqlSessionFactory.openSession(true);

            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            mapper.updateStu(stu);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteStu(String number) {
        InputStream is = null;
        SqlSession sqlSession = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");

            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            sqlSession = sqlSessionFactory.openSession(true);

            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

            mapper.deleteStu(number);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}