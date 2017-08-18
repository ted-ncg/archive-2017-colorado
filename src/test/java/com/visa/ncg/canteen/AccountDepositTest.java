package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountDepositTest {

  @Test
  public void deposit5And20ResultsInBalanceOf25() throws Exception {
    Account account = new Account();

    account.deposit(5);
    account.deposit(20);

    assertThat(account.getBalance())
        .isEqualTo(25);
  }

  @Test
  public void deposit15ToAccountWithZeroBalanceResultsInAccountWith15Balance() throws Exception {
    Account account = new Account();

    account.deposit(15);

    assertThat(account.getBalance())
        .isEqualTo(15);
  }

}