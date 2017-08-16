package com.visa.ncg.canteen;

public class Account {

  private Long id = new Long(0);
  private int balance;

  public int getBalance() {
    return balance;
  }

  public Long getId() {
      return id;
  }

  public void setId(Long set) {
      id = set;
  }

  public void deposit(int amount) {
    balance += amount;
  }
}
