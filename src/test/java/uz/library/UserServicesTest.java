package uz.library;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import uz.library.dto.ResponseDto;
import uz.library.dto.UsersDto;
import uz.library.service.UsersService;
import uz.library.service.validator.AppStatusMessages;

import static org.junit.jupiter.api.Assertions.*;
import static uz.library.service.validator.AppStatusCodes.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServicesTest {

    @Autowired
    private UsersService usersService;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/sql/delete-test-values-addUserTestOnSuccess.sql")
    @DisplayName("Add user test on success when user is added!")
    public void addUserTestOnSuccess() {
        UsersDto usersDto = UsersDto.builder()
                .name("Test")
                .sureName("Case")
                .email("testOnSuccess@gmail.com")
                .role("USER")
                .gender("MALE")
                .passportId("AA12345")
                .phoneNumber("+998931234567")
                .address("TestAddress")
                .build();

        ResponseDto<UsersDto> response = usersService.addUser(usersDto);

        assertEquals(response.getMessage(), AppStatusMessages.OK);
        assertEquals(response.getData().getEmail(), usersDto.getEmail(), "Incorrect value returned after saving!");
        assertEquals(response.getCode(), OK_CODE, "Incorrect response code!");
        assertTrue(response.isSuccess());
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/sql/insert-test-values-addUserTestOnFail.sql")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/sql/delete-test-values-addUserTestOnFail.sql")
    @DisplayName("Add user test on failed when user is added!")
    public void addUserTestOnFail(){
        UsersDto usersDto = UsersDto.builder()
                .name("TestOnFail")
                .sureName("CaseOnFail")
                .email("testOnFail@gmail.com")
                .role("USER")
                .gender("MALE")
                .passportId("AA12345")
                .phoneNumber("+998999875463")
                .build();

        ResponseDto<UsersDto> response = usersService.addUser(usersDto);

        assertEquals(response.getCode(), DATABASE_ERROR_CODE, "Incorrect error code!");
        assertFalse(response.isSuccess());
    }

    @Test
    @DisplayName("Delete user by id test on user not found case!")
    public void deleteUserByIdTestOnUserNotFound(){
        ResponseDto<Void> response = usersService.deleteUserById(2147483647);

        assertEquals(response.getMessage(), AppStatusMessages.NOT_FOUND);
        assertEquals(response.getCode(), NOT_FOUND_ERROR_CODE);
        assertNull(response.getData());
    }

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "/sql/insert-test-values-deleteUserByIdTestOnSuccess.sql")
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "/sql/delete-test-values-deleteUserByIdTestOnSuccess.sql")
    public void deleteUserByIdTestOnSuccess(){
        ResponseDto<Void> response = usersService.deleteUserById(2147483647);

        assertEquals(response.getCode(), OK_CODE, "Incorrect code from response!");
        assertEquals(response.getMessage(), AppStatusMessages.OK);
        assertTrue(response.isSuccess());
    }

}
