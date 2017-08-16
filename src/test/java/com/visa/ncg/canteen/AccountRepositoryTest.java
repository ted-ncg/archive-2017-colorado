package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTest {

    @Test
    public void saveTest() throws Exception {
        Account test = new Account();
        AccountRepository testRepo = new AccountRepository();

        testRepo.save(test);

        assertThat(testRepo.findAll().size()).isEqualTo(1);
    }

    @Test
    public void findOneTest() throws Exception {
        Account test = new Account();
        AccountRepository testRepo = new AccountRepository();

        testRepo.save(test);
        Account resultAccount = testRepo.findOne(Long.valueOf("1"));

        assertThat(resultAccount).isNotNull();
    }

    @Test
    public void findAllTest() throws Exception {
        Account test1 = new Account();
        Account test2 = new Account();
        AccountRepository testRepo = new AccountRepository();

        testRepo.save(test1);
        testRepo.save(test2);

        assertThat(testRepo.findAll().size()).isEqualTo(2);
    }

}
