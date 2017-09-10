package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryAccountRepositorySaveTest {

  @Test
  public void saveAccountWithoutIdReturnsAccountWithId() throws Exception {
    InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository(new AtomicLongSequence());
    Account account = new Account();

    Account savedAccount = inMemoryAccountRepository.save(account);

    assertThat(savedAccount.getId())
        .isNotNull();

    assertThat(inMemoryAccountRepository.findOne(savedAccount.getId()))
        .isNotNull();
  }

  @Test
  public void saveAccountWithIdDoesNotChange() throws Exception {
    InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository(new AtomicLongSequence());
    Account account = new Account();
    account.setId(12L);

    Account savedAccount = inMemoryAccountRepository.save(account);

    assertThat(savedAccount.getId())
        .isEqualTo(12L);

    assertThat(inMemoryAccountRepository.findOne(12L))
        .isNotNull();
  }

  @Test
  public void saveTwoNewAccountsAssignsUniqueIds() throws Exception {
    Account account1 = new Account();
    Account account2 = new Account();
    InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository(new AtomicLongSequence());
    inMemoryAccountRepository.save(account1);
    inMemoryAccountRepository.save(account2);

    assertThat(account1.getId())
        .isNotEqualTo(account2.getId());
  }
}
