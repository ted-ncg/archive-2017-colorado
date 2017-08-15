package com.visa.ncg.canteen;

import java.io.*;

public class InsufficientFundsException extends Exception
{

    public InsufficientFundsException() {

    }

    public InsufficientFundsException(String error) {

        super(error);
    }

}