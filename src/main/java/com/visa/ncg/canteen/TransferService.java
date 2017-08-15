package com.visa.ncg.canteen;

public class TransferService {

  public void transfer(ExternalAccount externalAccount, Account account, int amount) {
    externalAccount.withdraw(amount);
    account.deposit(amount);
  }
}
