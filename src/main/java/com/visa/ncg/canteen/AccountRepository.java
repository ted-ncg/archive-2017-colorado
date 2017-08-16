package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class AccountRepository {

  private Map<Long, Account> accountIdMap = new HashMap<>();

  private final AtomicLong sequence = new AtomicLong();

  public AccountRepository(List<Account> accounts) {
    for (Account account: accounts) {
      accountIdMap.put(account.getId(), account);
    }
  }

  public AccountRepository() {
    // empty
  }

  public List<Account> findAll() {
    return new ArrayList<>(accountIdMap.values());
  }

  public Account findOne(Long id) {
    return accountIdMap.get(id);
  }

  public Account save(Account account) {
    if (account.getId() == null) {
      account.setId(sequence.getAndIncrement());
    }
    accountIdMap.put(account.getId(), account);

    return account;
  }
}
