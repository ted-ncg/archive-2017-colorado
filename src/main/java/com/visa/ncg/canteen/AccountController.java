package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

  private AccountRepository accountRepository;

  @Autowired
  public AccountController(AccountRepository accountRepository) {
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
    List<Account> accounts = accountRepository.findAll();
    model.addAttribute("accounts", accounts);
    return "all-accounts";
  }

}
