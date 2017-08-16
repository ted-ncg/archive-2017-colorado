package com.visa.ncg.canteen;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongSequence implements Sequence {
  private AtomicLong atomicLong = new AtomicLong();

  @Override
  public Long nextValue() {
    return atomicLong.getAndIncrement();
  }
}
