package com.visa.ncg.canteen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

  private int balance;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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
