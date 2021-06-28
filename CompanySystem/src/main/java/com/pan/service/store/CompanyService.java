package com.pan.service.store;

import com.github.pagehelper.PageInfo;
import com.pan.domain.store.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    PageInfo findAll(int page,int size);

    Company findById(String id);

    void delete(String id);

    void save(Company company);

    void update(Company company);
}
