package com.revolut;

import com.revolut.config.MoneyTransferConfiguration;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class MoneyTransferApplication extends Application<MoneyTransferConfiguration> {


    public static void main(String[] args) throws Exception {
        new MoneyTransferApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<MoneyTransferConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
    }

    @Override
    public void run(MoneyTransferConfiguration configuration, Environment environment) {

    }
}
