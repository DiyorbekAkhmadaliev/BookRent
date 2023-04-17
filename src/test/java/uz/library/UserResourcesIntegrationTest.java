package uz.library;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import uz.library.dto.UsersDto;
import uz.library.rest.UsersResources;

import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserResourcesIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UsersResources usersResources;

    @Test
    @DisplayName("Integration test for user getAllUsers API")
    public void getAllUsersTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("Integration test for addUserOnSuccess method case = Success!")
    public void addUsersTestOnSuccess() throws Exception {

        String requestBody = objectMapper.writeValueAsString(UsersDto.builder()
                .name("IntegrationTest")
                .sureName("IntegrationCase")
                .email("integrationtest@gmail.com")
                .phoneNumber("+998913214569")
                .role("USER")
                .gender("MALE")
                .passportId("CC123456789")
                .build());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
                .accept(MediaType.ALL);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @Test
    @DisplayName("Integration test addUserTestOnBadRequestValidationError method case = Bad request!")
    public void addUserTestOnBadRequestValidationError() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .content(
                                objectMapper.writeValueAsString(
                                        UsersDto.builder()
                                                .name("test_45d9c0e2eadc")
                                                .sureName("test_ce98f1efb1a8")
                                                .gender("test_8e5436f99f4c")
                                                .passportId("test_5554262d2e74")
                                                .phoneNumber("test_019eeee286f0")
                                                .email("test_497466365275")
                                                .address("test_532fb7221776")
                                                .role("test_a91507627adc")
                                                .build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/sql/insert-test-value-updateUserTestOnSuccess.sql")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/sql/delete-test-values-updateUserTestOnSuccess.sql")
    public void updateUserTestOnSuccess() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.patch("/user")
                .content(objectMapper.writeValueAsString(UsersDto.builder()
                        .Id(21474836)
                        .name("updateUserTestOnSuccess")
                        .sureName("updateUserTestOnSuccess")
                        .role("USER")
                        .gender("FEMALE")
                        .phoneNumber("+998934567893")
                        .address("TestAddress")
                        .email("updateUserTestOnSuccess@gmail.com")
                        .passportId("DD3214567")
                        .build()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.ALL)
        ).andExpectAll(
                status().isOk(),
                content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)
        );
    }
}
