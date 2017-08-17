package com.visa.ncg.canteen;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class AtomicLongSequence implements Sequence {
  private AtomicLong atomicLong = new AtomicLong(1); // first ID will be 1

  @Override
  public Long nextValue() {
    return atomicLong.getAndIncrement();
  }
}
