package com.pan.service.store.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pan.Dao.store.CompanyDao;
import com.pan.domain.store.Company;
import com.pan.factory.MapperFactory;
import com.pan.service.store.CompanyService;
import com.pan.utils.TransactionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.UUID;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public List<Company> findAll() {
        SqlSession sqlSession = null;
        List<Company> companyList = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            companyList = companyDao.findAll();
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
            return companyList;
        }
    }

    @Override
    public PageInfo findAll(int page, int size) {
        SqlSession sqlSession = null;
        PageInfo pageInfo = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            PageHelper.startPage(page, size);
            List<Company> all = companyDao.findAll();
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
    public Company findById(String id) {
        SqlSession sqlSession = null;
        Company company = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            company = companyDao.findById(id);
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
            return company;
        }
    }

    @Override
    public void delete(String id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            companyDao.delete(id);
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
    public void save(Company company) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            String id = UUID.randomUUID().toString();
            company.setId(id);
            companyDao.save(company);
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
    public void update(Company company) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MapperFactory.getSqlSession();
            CompanyDao companyDao = MapperFactory.getMapper(sqlSession, CompanyDao.class);
            companyDao.update(company);
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
