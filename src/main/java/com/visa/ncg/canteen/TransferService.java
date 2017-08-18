package com.visa.ncg.canteen;

public class TransferService {

  public void transfer(ExternalAccount externalAccount, Account account, int amount) {
    if (amount <= 0) {
      throw new IllegalTransferAmountException("Not allowed to transfer 0 or negative amounts, requested amount was: " + amount);
    }
    externalAccount.withdraw(amount);
    account.deposit(amount);
  }
}
