package uz.library.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import uz.library.service.validator.GenderValidator;
import uz.library.service.validator.PhoneNumberValidator;

import static uz.library.service.validator.AppStatusMessages.EMPTY_STRING;
import static uz.library.service.validator.AppStatusMessages.VALIDATION_ERROR;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersDto {

    private Integer Id;
    @Size(max = 25, message = VALIDATION_ERROR)
    private String name;
    @Size(max = 25, message = VALIDATION_ERROR)
    private String sureName;
    @GenderValidator
    private String gender;
    private String passportId;
    @NotBlank(message = EMPTY_STRING)
    @PhoneNumberValidator(message = VALIDATION_ERROR)
    private String phoneNumber;
    @Email
    @NotBlank(message = EMPTY_STRING)
    private String email;
    private String address;
    private String role;

    /**
     * <p>0 -> User is considered as deleted</p>
     * <p>1 -> User is considered as present</p>
     */
    private short isActive;
}
