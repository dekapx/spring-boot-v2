package com.example.pojo.validator;

import com.example.pojo.model.ErrorMessagePojo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PropertyValidatorImpl<T> implements PropertyValidator<T> {
    @Override
    public void validateFields(final T requestClass) {
        final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        final Validator validator = validatorFactory.getValidator();
        final Set<ConstraintViolation<Object>> propertyViolation = validator.validate(requestClass);
        final List<String> errorMessages = new ArrayList<>();
        if (!propertyViolation.isEmpty()) {
            errorMessages.addAll(propertyViolation
                    .stream()
                    .map(p -> p.getMessage())
                    .collect(Collectors.toList()));
            throw new ConstraintViolationException(prepareErrorMessagePojo(errorMessages));
        }
    }

    private ErrorMessagePojo prepareErrorMessagePojo(final List<String> errorMessages ) {
        return ErrorMessagePojo.builder()
                .errorMessage(errorMessages)
                .statusCode(HttpStatus.BAD_REQUEST)
                .build();
    }
}
