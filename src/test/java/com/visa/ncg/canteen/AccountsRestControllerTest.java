package com.visa.ncg.canteen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountsController.class)
public class AccountsRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean // !! Not @Mock !!
  private AccountRepository mockAccountRepository;

  @Before
  public void loadMockData() {
    Account account1 = new Account();
    account1.setId(1L);
    account1.deposit(10);
    when(mockAccountRepository.findOne(1L)).thenReturn(account1);
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