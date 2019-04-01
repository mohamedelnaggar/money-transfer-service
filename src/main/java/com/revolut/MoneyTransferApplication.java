package com.revolut;

import com.revolut.config.MoneyTransferAccountHibernateBundle;
import com.revolut.config.MoneyTransferConfiguration;
import com.revolut.dao.AccountDao;
import com.revolut.rest.AccountResource;
import com.revolut.service.AccountService;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MoneyTransferApplication extends Application<MoneyTransferConfiguration> {


    public static void main(String[] args) throws Exception {
        new MoneyTransferApplication().run(args);
    }

    private final MoneyTransferAccountHibernateBundle moneyTransferAccountHibernateBundle;


    public MoneyTransferApplication(){
        this.moneyTransferAccountHibernateBundle = new MoneyTransferAccountHibernateBundle();
    }

    @Override
    public void initialize(final Bootstrap<MoneyTransferConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        bootstrap.addBundle(moneyTransferAccountHibernateBundle);
    }

    @Override
    public void run(MoneyTransferConfiguration configuration, Environment environment) {
        AccountDao accountDao = new AccountDao(moneyTransferAccountHibernateBundle.getSessionFactory());
        AccountService accountService = new AccountService(accountDao);
        environment.jersey().register(new AccountResource(accountService));
    }

}
