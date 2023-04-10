package uz.library.service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = PhoneNumberValidatorImpl.class)
public @interface PhoneNumberValidator {

    String message() default "Invalid phone number";
    Class<?>[] groups() default {}; // Add groups parameter
    Class<? extends Payload>[] payload() default {};
}
