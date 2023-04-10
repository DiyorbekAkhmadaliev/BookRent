package uz.library.service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uz.library.dto.ChooseGender;

import static uz.library.dto.ChooseGender.*;

public class GenderValidatorImpl implements ConstraintValidator<GenderValidator, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.toUpperCase().equals(MALE.getName()) || value.toUpperCase().equals(FEMALE.getName());
    }
}
