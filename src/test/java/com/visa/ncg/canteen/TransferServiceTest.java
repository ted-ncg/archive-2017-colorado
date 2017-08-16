package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TransferServiceTest {

  @Test
  public void transferTenDollarsFromExternalAccountToAccountIncreasesAccountBalance() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount(20);
    Account account = new Account();
    TransferService transferService = new TransferService();

    transferService.transfer(externalAccount, account, 10);

    assertThat(account.getBalance())
        .isEqualTo(10);
  }

  @Test
  public void notHavingSufficientFund2BeTransferred() {
    ExternalAccount externalAccount = new ExternalAccount(20);
    Account account = new Account();
    TransferService transferService = new TransferService();

    assertThatThrownBy(() -> {transferService.transfer(externalAccount, account, 100);})
            .isInstanceOf(InsufficientFundsException.class)
            .hasMessageContaining("insufficientFunds");
  }
}
