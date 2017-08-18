package com.visa.ncg.canteen;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountDataLoader implements ApplicationRunner {
  private AccountRepository accountRepository;

  public AccountDataLoader(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  /**
   * Add two accounts to the repository with IDs 1, 10, and 11
   */
  @Override
  public void run(ApplicationArguments args) throws Exception {
    Account account1 = new Account();
    account1.setId(1L);
    account1.deposit(100);
    accountRepository.save(account1);

    Account account10 = new Account();
    account10.setId(10L);
    account10.deposit(23);
    accountRepository.save(account10);

    Account account11 = new Account();
    account11.setId(11L);
    account11.deposit(3);
    accountRepository.save(account11);
  }
}
