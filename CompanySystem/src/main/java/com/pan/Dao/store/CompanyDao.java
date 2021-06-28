package com.pan.Dao.store;

import com.pan.domain.store.Company;

import java.util.List;

public interface CompanyDao {

    List<Company> findAll();

    Company findById(String id);

    int delete(String id);

    int save(Company company);

    int update(Company company);
}
