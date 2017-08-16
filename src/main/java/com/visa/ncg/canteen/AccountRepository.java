package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {

  private Map<Long, Account> accountIdMap = new HashMap<>();

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
}
