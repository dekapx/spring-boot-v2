package com.dekapx.apps.core.validator;

import com.dekapx.apps.core.annotation.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.dekapx.apps.core.common.CommonConstants.EMAIL_REGEX;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {
        final var pattern = Pattern.compile(EMAIL_REGEX);
        final var matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
