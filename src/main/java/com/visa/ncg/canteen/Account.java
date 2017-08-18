package com.visa.ncg.canteen;

public class Account {

  private int balance;
  private Long id;

  public int getBalance() {
    return balance;
  }

  public void deposit(int amount) {
    balance += amount;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Account{" +
        "balance=" + balance +
        ", id=" + id +
        '}';
  }
}
