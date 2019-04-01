package com.revolut.service;

import com.revolut.dao.AccountDao;
import com.revolut.entity.Account;

import java.util.List;


public class AccountService {

    private final AccountDao accountDao;

    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> getAllAccounts(){
        return accountDao.findAll();
    }

    public Account getAccountDetails(Long accountId){
        return accountDao.findById(accountId);
    }

    public Account saveOrUpdate(Account account){
        return accountDao.saveOrUpdate(account);
    }

}
