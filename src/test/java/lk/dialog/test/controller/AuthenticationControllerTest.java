package lk.dialog.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.dialog.test.request.AuthenticationRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() throws  Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void checkTokenCreate() throws Exception{
        AuthenticationRequest authenticationRequest = new AuthenticationRequest("shehan","123");
        String jsonRequest = objectMapper.writeValueAsString(authenticationRequest);

        mockMvc.perform
                        (MockMvcRequestBuilders.post("/authenticate")
                                .content(jsonRequest)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                .andExpect(MockMvcResultMatchers.jsonPath("$.jwt").exists())
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
   }



}
