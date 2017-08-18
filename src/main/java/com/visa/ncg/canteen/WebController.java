package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

  private AccountRepository accountRepository;
  private CurrencyService currencyService;

  @Autowired
  public WebController(AccountRepository accountRepository, CurrencyService currencyService) {
    this.accountRepository = accountRepository;
    this.currencyService = currencyService;
  }

  @GetMapping("account/{id}") // -> /account/{id}
  public String viewAccount(@PathVariable("id") String accountId,
                            Model model) {
    Long id = Long.valueOf(accountId);
    Account account = accountRepository.findOne(id);
    Integer converted = currencyService.convertToGbp((account.getBalance()));
    model.addAttribute("account", account);
    model.addAttribute("converted", converted);

    return "account-view";
  }

  @GetMapping("/account")
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

  @GetMapping("/deposit/{id}")
  public String depositGet(Model model,
                           @PathVariable("id") long id) {
    // put the Account object for the id into the model
    // create a new DepositForm and set its accountId
    Account account = accountRepository.findOne(id);
    DepositForm depositForm = new DepositForm();
    depositForm.setAccountId(id);
    model.addAttribute("account", account);
    model.addAttribute("depositForm", depositForm);

    return "deposit";
  }

  @PostMapping("/deposit")
  public String depositPost(@ModelAttribute DepositForm form) {
    // get the account ID from the form
    // execute the deposit on that account
    // save the account back to the repository
    Account account = new Account();

    account.setId(form.getAccountId());
    Account curentAccountBalance = accountRepository.findOne(form.getAccountId());
    account.deposit(curentAccountBalance.getBalance() + form.getAmount());

    accountRepository.save(account);

    return "redirect:/account/" + form.getAccountId();
  }

}
