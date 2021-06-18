package com.pan.Utils;

import com.pan.dao.CompanyDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    public  CompanyDao getMapper(){
        InputStream is = null;
        SqlSession sqlSession = null;
        CompanyDao mapper = null;
        try {
            is = Resources.getResourceAsStream("myBatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(CompanyDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (sqlSession != null) {
                sqlSession.close();
            }
            return mapper;
        }
    }
}
