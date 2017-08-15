package com.visa.ncg.canteen;


import java.io.*;


public class IllegalTransferAmmountException extends  Exception{

    public IllegalTransferAmmountException(){}

    public IllegalTransferAmmountException(String error){
        super(error);
    }
}
