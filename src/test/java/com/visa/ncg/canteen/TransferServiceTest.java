package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TransferServiceTest {

  @Test
  public void transferTenDollarsFromExternalAccountToAccountIncreasesAccountBalance() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount(10);
    Account account = new Account();
    TransferService transferService = new TransferService();

    transferService.transfer(externalAccount, account, 10);

    assertThat(account.getBalance())
        .isEqualTo(10);
  }

  @Test
  public void insufficientFundsTest() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount(0);
    Account account = new Account();
    TransferService transferService = new TransferService();

    assertThatExceptionOfType(InsufficientFundsException.class).isThrownBy(() -> { transferService.transfer(externalAccount, account, 10);});

  }

  @Test
  public void illegalTransferAmountTest() throws Exception {
    ExternalAccount externalAccount = new ExternalAccount(10);
    Account account = new Account();
    TransferService transferService = new TransferService();

    assertThatExceptionOfType(IllegalTransferAmountException.class).isThrownBy(() -> {transferService.transfer(externalAccount, account, 0);});
  }
}
