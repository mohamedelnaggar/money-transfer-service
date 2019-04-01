package com.revolut.dao;

import com.revolut.entity.Account;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class AccountDao extends AbstractDAO<Account> {

    public AccountDao(SessionFactory factory) {
        super(factory);
    }

    public void create(Account sample) {
        persist(sample);
    }

    public List<Account> findAll() {
        return list(currentSession().createQuery("from Account"));
    }
}
