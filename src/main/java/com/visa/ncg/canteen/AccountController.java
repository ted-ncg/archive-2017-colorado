package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    @GetMapping("/{id}")
    public Account accountInfo( @PathVariable ("id") String accountId) throws Exception {

        Account account = new Account();

        account.deposit(100);

        return account;
    }



}
