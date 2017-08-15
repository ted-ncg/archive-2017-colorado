package com.visa.ncg.canteen;

public class Account {

  private int balance;

  public int getBalance() {
    return balance;
  }

  public void deposit(int amount) throws Exception {

    if (amount <= 0)
      throw new IllegalTransferAmountException();
    else
      balance += amount;
  }
}
