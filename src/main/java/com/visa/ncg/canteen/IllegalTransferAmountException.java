package com.visa.ncg.canteen;

public class IllegalTransferAmountException extends Exception {

    public IllegalTransferAmountException() {

    }

    public IllegalTransferAmountException(String message) {
        super(message);
    }
}
