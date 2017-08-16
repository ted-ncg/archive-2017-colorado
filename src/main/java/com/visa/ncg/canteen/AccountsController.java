package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

  // GET -> http://localhost:8080/accounts/123
  @GetMapping("/{id}")
  public Account getAccountInfo(@PathVariable("id") String stringId) {
    long accountId = Long.valueOf(stringId);

    Account account = new Account();
    account.deposit(22);

    return account;
  }


}
