package com.visa.ncg.canteen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountsController.class)
public class AccountsRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @TestConfiguration
  static class Config {

    @Bean
    public AccountRepository createTestAccountRepository() {
      FakeSequence sequence = new FakeSequence(1L);
      AccountRepository accountRepository = new AccountRepository(sequence);
      Account account = new Account();
      account.deposit(10);
      accountRepository.save(account);
      return accountRepository;
    }

  }

  @Test
  public void getReturnsAccountWithBalance() throws Exception {
    MvcResult result = mockMvc.perform(get("/api/accounts/1"))
        .andExpect(status().isOk())
        .andReturn();
    String body = result.getResponse().getContentAsString();
    assertThat(body)
        .contains("\"balance\"");
  }

  @Test
  public void getWithAccountIdReturnsAccountForThatId() throws Exception {
    mockMvc.perform(get("/api/accounts/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.balance").value("10"));
  }
}