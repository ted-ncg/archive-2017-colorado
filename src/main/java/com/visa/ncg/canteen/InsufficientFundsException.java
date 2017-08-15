package com.visa.ncg.canteen;

public class InsufficientFundsException extends Exception{

    // Parameterless Constructor
    public InsufficientFundsException() {}

    // Constructor that accepts a message
    public InsufficientFundsException(String message)
    {
        super(message);
    }
}
