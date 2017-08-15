package com.visa.ncg.canteen;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {

    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}
