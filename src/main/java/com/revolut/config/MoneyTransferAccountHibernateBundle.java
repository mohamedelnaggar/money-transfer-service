package com.revolut.config;

import com.revolut.entity.Account;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class MoneyTransferAccountHibernateBundle extends HibernateBundle<MoneyTransferConfiguration> {

    public MoneyTransferAccountHibernateBundle() {
        super(Account.class);
    }

    @Override
    public PooledDataSourceFactory getDataSourceFactory(MoneyTransferConfiguration configuration) {
        return configuration.getDataSourceFactory();
    }
}
