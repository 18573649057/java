package com.pan.service;

import com.pan.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(int id);

    void update(Account account);

    void save(Account account);

    void delete(int id);
}
