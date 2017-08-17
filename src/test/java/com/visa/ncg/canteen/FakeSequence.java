package com.visa.ncg.canteen;

public class FakeSequence implements Sequence {
  private Long nextValue;

  public FakeSequence(Long nextValue) {
    this.nextValue = nextValue;
  }

  @Override
  public Long nextValue() {
    return nextValue;
  }
}
