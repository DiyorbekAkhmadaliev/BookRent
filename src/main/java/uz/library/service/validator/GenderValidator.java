package uz.library.service.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = GenderValidatorImpl.class)
public @interface GenderValidator {

    String message() default "Invalid gender";
    Class<?>[] groups() default {}; // Add groups parameter
    Class<? extends Payload>[] payload() default {};
}
