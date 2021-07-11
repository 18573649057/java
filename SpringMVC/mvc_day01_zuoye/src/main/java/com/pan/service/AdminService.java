package com.pan.service;
import com.pan.domain.Admin;

import java.util.List;

public interface AdminService {

    void save(Admin admin);

    void delete(String username);

    void update(Admin admin);

    List<Admin> findAll();
}
