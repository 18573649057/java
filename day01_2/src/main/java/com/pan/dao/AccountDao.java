package com.pan.dao;

import com.pan.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public interface AccountDao {

    List<Account> findAll();

    Account findById(int id);

    void update(Account account);

    void save(Account account);

    void delete(int id);
}
