package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class IllegalTransferAmmountTest {

    @Test
    public void ifIllegalTransferAmmountTest() throws IllegalTransferAmmountException {
        ExternalAccount externalAccount = new ExternalAccount(5);


        assertThatThrownBy(() -> {
            externalAccount.withdraw(-1);
        })
                .isInstanceOf(IllegalTransferAmmountException.class);
    }

}


