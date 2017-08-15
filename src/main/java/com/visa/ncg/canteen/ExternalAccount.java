package com.visa.ncg.canteen;

public class ExternalAccount {

  private int balance;

  public ExternalAccount() {
    balance = 0;
  }

  public ExternalAccount(int initialBalance) {
    balance = initialBalance;
  }

  public int getBalance() {
    return balance;
  }

  public void withdraw(int amount) throws InsufficientFundsException, IllegalTransferAmmountException {

      if (amount <= 0) {
        throw new IllegalTransferAmmountException("Error");
      }

      else if (amount > balance) {
        throw new InsufficientFundsException("Error");
      }
      else
      {
        balance -= amount;
      }
    }



  }




