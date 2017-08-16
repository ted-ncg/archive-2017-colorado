package com.visa.ncg.canteen;

public class FakeSequence implements Sequence {
  private Long nextValue;

  public void setNextValue(Long nextValue) {
    this.nextValue = nextValue;
  }

  @Override
  public Long nextValue() {
    return nextValue;
  }
}
