package com.visa.ncg.canteen;

public class TransferService {

  public void transfer(ExternalAccount externalAccount, Account account, int amount) {
    if (amount <= 0) {
      throw new IllegalTransferAmountException("Can not transfer " + amount);
    }
    externalAccount.withdraw(amount);
    account.deposit(amount);
  }
}
