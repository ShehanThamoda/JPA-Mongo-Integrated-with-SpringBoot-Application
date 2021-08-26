package lk.dialog.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.dialog.test.request.EmployeeAddRequest;
import lk.dialog.test.response.EmployeeAddResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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
public class RequestControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    EmployeeAddResponse employeeAddResponse;

    @Before
    public void setup() throws  Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void afterAddingEmployeeRecord() throws Exception{
        EmployeeAddRequest employeeAddRequest =new EmployeeAddRequest("Sandun");
        String jsonRequest = objectMapper.writeValueAsString(employeeAddRequest);

        employeeAddResponse = Mockito.mock(EmployeeAddResponse.class);
        Mockito.when(employeeAddResponse.getId()).thenReturn(15);

        mockMvc.perform
                        (MockMvcRequestBuilders.post("/employee")
                                .content(jsonRequest)
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                        )
                    .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();
   }



}
