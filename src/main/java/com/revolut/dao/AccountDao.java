package com.revolut.dao;

import com.revolut.entity.Account;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class AccountDao extends AbstractDAO<Account> {

    public AccountDao(SessionFactory factory) {
        super(factory);
    }


    public List<Account> findAll() {
        return list(currentSession().createQuery("from Account"));
    }

    public Account findById(Long accountId) {
        return get(accountId);
    }

    public Account saveOrUpdate(Account account) {
        return persist(account);
    }
}
