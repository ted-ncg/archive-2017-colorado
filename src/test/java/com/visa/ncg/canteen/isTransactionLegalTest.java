package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class isTransactionLegalTest {

    @Test
    public void transferring5Dollars () throws Exception{

        int transferAmount = 5;

        Account account = new Account();

        int currentBalance = account.getBalance();

        account.deposit(transferAmount);

        assertThat(account.getBalance())
                .isEqualTo(currentBalance + transferAmount );

    }

    @Test
    public void transferring0Dollars () {

        int transferAmount = 0;

        Account account = new Account();

        assertThatThrownBy(() -> { account.deposit(transferAmount); }).isInstanceOf(IllegalTransferAmountException.class);


    }

    @Test
    public void transferringMinus10Dollars () {

        int transferAmount = -10;

        Account account = new Account();

        assertThatThrownBy(() -> { account.deposit(transferAmount); }).isInstanceOf(IllegalTransferAmountException.class);


    }
}
