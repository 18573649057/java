package com.pan.service.Impl;

import com.pan.bean.User;
import com.pan.mapper.StudentMapper;
import com.pan.mapper.UserMapper;
import com.pan.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class UserSeviceImpl implements UserService {
    @Override
    public List<User> login(User user) throws IOException {
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.login(user);
        is.close();
        sqlSession.close();
        return users;
    }
}
