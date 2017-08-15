package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TransferServiceTest {

  @Test
  public void transferTenDollarsFromExternalAccountToAccountIncreasesAccountBalance() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount();
    Account account = new Account();
    TransferService transferService = new TransferService();

    transferService.transfer(externalAccount, account, 10);

    assertThat(account.getBalance())
        .isEqualTo(10);
  }

  @Test
  public void transferIllegalAmount() {
    ExternalAccount externalAccount = new ExternalAccount();
    Account account = new Account();
    TransferService transferService = new TransferService();

    assertThatThrownBy(() -> {transferService.transfer(externalAccount, account, -10);})
            .isInstanceOf(IllegalTransferAmountException.class)
            .hasMessageContaining("Cannot transfer amounts less than or equal to 0");
  }

}
