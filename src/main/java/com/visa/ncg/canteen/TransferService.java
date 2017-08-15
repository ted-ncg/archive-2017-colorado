package com.visa.ncg.canteen;

public class TransferService {

  public void transfer(ExternalAccount externalAccount, Account account, int amount) throws Exception{

    if (amount <= 0) {
      throw new IllegalTransferAmountException("Cannot transfer amounts less than or equal to 0");
    }

      externalAccount.withdraw(amount);
      account.deposit(amount);

  }
}
