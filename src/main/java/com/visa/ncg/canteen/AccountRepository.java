package com.visa.ncg.canteen;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class AccountRepository {

    public HashMap<Long, Account> accounts;
    private AtomicLong idCounter;

    AccountRepository() {
        accounts = new HashMap<Long, Account>();
        idCounter = new AtomicLong();
    }

    public Account findOne(Long id) {
        return accounts.get(id);
    }

    public Account save(Account entity) {
        if (entity.getId() == 0) {
            entity.setId(idCounter.incrementAndGet());
        }
        if (!accounts.containsKey(entity.getId())) {
            accounts.put(idCounter.get(), entity);
        }
        return entity;
    }

    public List<Account> findAll() {
        return new ArrayList<Account>(accounts.values());
    }
}
