package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExternalAccountWithdrawTest {

  @Test
  public void having20BalanceWithdraw7ResultsIn13Balance() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount(20);

    externalAccount.withdraw(7);

    assertThat(externalAccount.getBalance())
        .isEqualTo(13);
  }

}