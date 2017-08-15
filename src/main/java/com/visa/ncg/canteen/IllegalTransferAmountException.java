package com.visa.ncg.canteen;

public class IllegalTransferAmountException extends Exception {

    //Parmerterless Constructor
    public IllegalTransferAmountException() {}

    //Constructor
    public IllegalTransferAmountException(String message)  {
        super(message);
    }
}
