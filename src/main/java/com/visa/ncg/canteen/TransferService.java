package com.visa.ncg.canteen;

public class TransferService {

  public void transfer(ExternalAccount externalAccount, Account account, int amount) throws Exception {
    if (amount < externalAccount.getBalance()) {
      throw new InsufficientFundsException("insufficientFunds");
    } else {
      externalAccount.withdraw(amount);
      account.deposit(amount);
    }
  }
}
