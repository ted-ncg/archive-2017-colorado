package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExternalAccountWithdrawTest {

  @Test
  public void having20BalanceWithdraw7ResultsIn13Balance() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount(20);

    externalAccount.withdraw(7);

    assertThat(externalAccount.getBalance())
        .isEqualTo(13);
  }

  @Test
  public void having10BalanceWithdraw18ThrowsException() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount(10);

    assertThatThrownBy(() -> externalAccount.withdraw(18))
        .isInstanceOf(InsufficientFundsException.class);
  }

}