package com.revolut.rest;


import com.codahale.metrics.annotation.Timed;
import com.revolut.entity.Account;
import com.revolut.service.AccountService;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.LongParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    private final Logger log = LoggerFactory.getLogger(AccountResource.class);

    private final AccountService accountService;

    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @GET
    @Timed
    @Path("/accounts")
    @UnitOfWork
    public Response getAllAccounts() {
        log.debug("REST request to get all account");
        return Response
                .status(Response.Status.OK)
                .entity(this.accountService.getAllAccounts())
                .build();
    }

    @GET
    @Timed
    @Path("/accounts/{id}")
    @UnitOfWork
    public Response getAccountDetails(@PathParam("id") LongParam accountId) {
        log.debug("REST request to get account details with id {}", accountId.get());
        return Response
                .status(Response.Status.OK)
                .entity(this.accountService.getAccountDetails(accountId.get()))
                .build();
    }

    @POST
    @Timed
    @Path("/accounts")
    @UnitOfWork
    public Response createNewAccount(Account account) {
        log.debug("REST request to create new account {}", account);
        return Response
                .status(Response.Status.CREATED)
                .entity(this.accountService.saveOrUpdate(account))
                .build();
    }


}
