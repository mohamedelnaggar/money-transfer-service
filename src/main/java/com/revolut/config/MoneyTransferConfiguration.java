package com.revolut.config;

import io.dropwizard.Configuration;

public class MoneyTransferConfiguration extends Configuration {

    private String name;

    public String getName() {
        return name;
    }

    public MoneyTransferConfiguration setName(String name) {
        this.name = name;
        return this;
    }
}
