package com.pan.service.store.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.Dao.store.UserDao;
import com.pan.domain.system.User;
import com.pan.factory.MapperFactory;
import com.pan.service.store.UserService;
import com.pan.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        SqlSession sqlSession = null;
        List<User> userList = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            userList = userDao.findAll();
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return userList;
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        PageInfo pageInfo = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            PageHelper.startPage(page, size);
            List<User> all = userDao.findAll();
            pageInfo = new PageInfo<>(all);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return pageInfo;
        }
    }

    @Override
    public User findById(String id) {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            user = userDao.findById(id);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return user;
        }
    }

    @Override
    public void delete(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            userDao.delete(id);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void save(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            String id = UUID.randomUUID().toString();
            user.setId(id);
            userDao.save(user);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            UserDao userDao = MapperFactory.getMapper(sqlSession, UserDao.class);
            userDao.update(user);
            TransactionUtil.commit(sqlSession);
        } catch (Exception e) {
            TransactionUtil.rollback(sqlSession);
            throw new RuntimeException(e);
        } finally {
            try {
                TransactionUtil.close(sqlSession);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
