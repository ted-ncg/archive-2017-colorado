package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/account")
public class WebController {

  private AccountRepository accountRepository;

  @Autowired
  public WebController(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @GetMapping("/{id}") // -> /account/{id}
  public String viewAccount(@PathVariable("id") String accountId,
                            Model model) {
    Long id = Long.valueOf(accountId);
    Account account = accountRepository.findOne(id);
    model.addAttribute("account", account);
    return "account-view";
  }

  @GetMapping("/")
  public String allAccounts(Model model) {
    List<Account> accounts = new ArrayList<>();
    Account account1 = new Account();
    account1.setId(10L);
    account1.deposit(23);
    accounts.add(account1);
    Account account2 = new Account();
    account2.setId(11L);
    account2.deposit(3);
    accounts.add(account2);

    model.addAttribute("accounts", accounts);
    return "all-accounts";
  }

}
