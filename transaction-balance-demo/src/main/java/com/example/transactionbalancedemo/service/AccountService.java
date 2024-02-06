package com.example.transactionbalancedemo.service;

import com.example.transactionbalancedemo.dao.AccountDao;
import com.example.transactionbalancedemo.ds.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    public int getBalance(String name){
        return accountDao.getBalance(name);
    }
    public List<Account> accountList(){
        return accountDao.listAllAccount();
    }
    @Transactional
    public void transfer(String fromName,String toName,int amount){
        withdraw(fromName,amount);
        System.out.println(5/0);
        deposit(toName,amount);
    }

    public void deposit(String name,int amount){
        accountDao.deposit(name,amount);
    }
    public void withdraw(String name,int amount){
        accountDao.withdraw(name,amount);
    }
}
