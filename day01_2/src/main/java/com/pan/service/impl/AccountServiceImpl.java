package com.pan.service.impl;

import com.pan.dao.AccountDao;
import com.pan.domain.Account;
import com.pan.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(int id) {
        return accountDao.findById(id);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void save(Account account) {
        accountDao.save(account);
    }

    public void delete(int id) {
        accountDao.delete(id);
    }


}
