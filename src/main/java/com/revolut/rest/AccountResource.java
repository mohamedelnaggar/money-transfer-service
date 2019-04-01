package com.revolut.rest;


import com.codahale.metrics.annotation.Timed;
import com.revolut.entity.Account;
import com.revolut.service.AccountService;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {


    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GET
    @Timed
    @Path("/accounts")
    @UnitOfWork
    public List<Account> sayHello() {
        return this.accountService.findAll();
    }


}
