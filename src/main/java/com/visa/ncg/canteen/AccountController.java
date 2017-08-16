package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @GetMapping("{id}")
    public Account accountInfo(String accountId) {
        Account test = new Account();
        test.deposit(10);
        return test;
    }

}
