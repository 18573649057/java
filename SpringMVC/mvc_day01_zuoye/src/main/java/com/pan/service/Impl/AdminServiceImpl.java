package com.pan.service.Impl;

import com.pan.dao.AdminDao;
import com.pan.domain.Admin;
import com.pan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {


    private AdminDao adminDao;

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }
    @Override
    public void save(Admin admin) {
        adminDao.save(admin);
    }
    @Override
    public void update(Admin admin){
        adminDao.update(admin);
    }

    @Override
    public List<Admin> findAll() {
            return adminDao.findAll();

    }
    @Override
    public void delete(String username) {
        adminDao.delete(username);
    }

}
