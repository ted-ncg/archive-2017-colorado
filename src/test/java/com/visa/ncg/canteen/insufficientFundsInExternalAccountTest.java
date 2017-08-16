package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class insufficientFundsInExternalAccountTest {

    @Test
    public void sufficientFundTestWithInitialBalance25AndWithdraw25 () throws Exception{

        int currentBalance;
        int withdrawAmount = 25;

        ExternalAccount externalAccount = new ExternalAccount(25);

        currentBalance = externalAccount.getBalance();

        externalAccount.withdraw(withdrawAmount);

        assertThat(externalAccount.getBalance())
                .isEqualTo(currentBalance - withdrawAmount);


    }

    @Test
    public void sufficientFundTestWithInitialBalance25AndWithdraw30 () {

        int withdrawAmount = 30;

        ExternalAccount externalAccount = new ExternalAccount(25);

        assertThatThrownBy(() -> { externalAccount.withdraw(withdrawAmount); }).isInstanceOf(InsufficientFundsExceptions.class);


    }

}
