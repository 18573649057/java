package com.pan.Servive;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {
    @Transactional
    public void transfer(String outName, String inName, Double money);
}
