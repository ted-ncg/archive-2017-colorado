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

  public void withdraw(int amount) {
    if (amount > balance) {
      throw new InsufficientFundsException("insufficientFunds");
    }
    balance -= amount;
  }
}
