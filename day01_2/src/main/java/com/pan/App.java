package com.pan;

import com.pan.domain.Account;
import com.pan.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = (AccountService) ctx.getBean("accountService");
        Account ac = accountService.findById(1);
        System.out.println(ac);

        Account account = new Account();
        account.setName("Tom");
        account.setMoney(123456.78);

        accountService.save(account);

    }
}
