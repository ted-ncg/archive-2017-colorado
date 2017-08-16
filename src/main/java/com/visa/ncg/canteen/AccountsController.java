package com.visa.ncg.canteen;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("api/accounts/{id}")
    public Account accountInfo(@PathVariable("id") String accountId){
        Account account = new Account();
        account.deposit(10);
        return account;

    }
}
