package com.visa.ncg.canteen;

public class InsufficientFundsExceptions extends Exception{

    @Override
    public String toString() {
        return ("There is insufficient funds");
    }
}
