package com.visa.ncg.canteen;

public class TransferService {

  public void transfer(ExternalAccount externalAccount, Account account, int amount) throws IllegalTransferAmountException, InsufficientFundsException {
    if (amount <= 0) {
      throw new IllegalTransferAmountException();
    } else if (externalAccount.getBalance() < amount) {
      throw new InsufficientFundsException();
    } else {
      externalAccount.withdraw(amount);
      account.deposit(amount);
    }

  }
}
