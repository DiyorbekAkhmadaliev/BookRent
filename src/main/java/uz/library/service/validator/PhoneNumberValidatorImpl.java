package uz.library.service.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PhoneNumberValidatorImpl implements ConstraintValidator<PhoneNumberValidator, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> phoneCodes = List.of("33","88","90","91","93","94","95","97","98","99","71","50","55");

        return s.length() == 9 && phoneCodes.contains(s.substring(4,6));
    }
}
