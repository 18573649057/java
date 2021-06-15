package com.itheima.service.Imlp;

import com.itheima.bean.User;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> login(User user) {
        InputStream is = null;
        SqlSession sqlSession = null;
        List<User> list = null;
        try{

            is = Resources.getResourceAsStream("mybatisConfig.xml");


            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);


            sqlSession = sqlSessionFactory.openSession(true);


            UserMapper mapper = sqlSession.getMapper(UserMapper.class);


            list = mapper.login(user);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {

            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}
