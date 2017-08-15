package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InsufficientFundsTest {


    @Test
    public void ifInsufficientFundsInExternalAccount() throws InsufficientFundsException {
        ExternalAccount externalAccount = new ExternalAccount(5);


        assertThatThrownBy(() -> {
            externalAccount.withdraw(15);
        })
                .isInstanceOf(InsufficientFundsException.class);
    }

}
