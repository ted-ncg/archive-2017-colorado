package com.visa.ncg.canteen;

public class IllegalTransferAmountException extends RuntimeException {

  public IllegalTransferAmountException() {
    super();
  }

  public IllegalTransferAmountException(String message) {
    super(message);
  }

}
