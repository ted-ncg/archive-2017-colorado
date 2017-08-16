package com.visa.ncg.canteen;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    @GetMapping("/accounts/{accountId}")
    public Account accountInfo(@PathVariable String accountId) {
        Account account = new Account();
        account.deposit(24);
        return account;
    }
}
