package com.pan.controller.Impl;

import com.github.pagehelper.PageInfo;
import com.pan.Utils.MybatisUtils;
import com.pan.bean.Company;
import com.pan.controller.CompanyService;
import com.pan.dao.CompanyDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    private MybatisUtils utils = new MybatisUtils();
    private CompanyDao mapper = utils.getMapper();

    @Override
    public void save(Company company) {
        mapper.save(company);
    }

    @Override
    public void delete(Company company) {
        mapper.delete(company);
    }

    @Override
    public void update(Company company) {
        mapper.update(company);
    }

    @Override
    public Company findById(String id) {
        Company company = mapper.findById(id);
        return company;

    }

    @Override
    public List<Company> findAll() throws IOException {
//        InputStream is = null;
//        SqlSession sqlSession = null;
//        List<Company> all = null;
//        try {
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CompanyDao mapper = sqlSession.getMapper(CompanyDao.class);
        List<Company> all = mapper.findAll();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (is != null) {
//                    is.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            if (sqlSession != null) {
//                sqlSession.close();
//            }
        return all;
    }

    @Override
    public PageInfo findAll(int page, int size) {
        return mapper.findAll(page, size);
    }
}
