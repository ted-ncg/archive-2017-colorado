package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AccountRepository {

  private Map<Long, Account> accountIdMap = new HashMap<>();

  private final Sequence sequence;

  public AccountRepository(List<Account> accounts, Sequence sequence) {
    this.sequence = sequence;
    for (Account account: accounts) {
      accountIdMap.put(account.getId(), account);
    }
  }

  @Autowired
  public AccountRepository(Sequence sequence) {
    // empty
    this.sequence = sequence;
  }

  public List<Account> findAll() {
    return new ArrayList<>(accountIdMap.values());
  }

  public Account findOne(Long id) {
    return accountIdMap.get(id);
  }

  public Account save(Account account) {
    if (account.getId() == null) {
      account.setId(sequence.nextValue());
    }
    accountIdMap.put(account.getId(), account);

    return account;
  }
}
