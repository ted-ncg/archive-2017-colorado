package com.visa.ncg.canteen;

public class IllegalTransferAmountException extends Exception {

    @Override
    public String toString() {
        return ("This is an illegal transaction");
    }
}
