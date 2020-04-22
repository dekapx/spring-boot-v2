package com.example.pojo.validator;

import com.example.pojo.model.PojoRequest;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Tested;
import mockit.VerificationsInOrder;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PropertyValidatorImplTest {
    @Tested
    private PropertyValidatorImpl propertyValidatorImpl;

    @Mocked
    private ValidatorFactory validatorFactoryMock;
    @Mocked
    private Validator validatorMock;
    @Mocked
    private ConstraintViolation<Object> constraintViolationMock;

    @Test
    public void validateFields_withInvalidPojoRequest_throwsConstraintViolationException() {
        prepareValidatorFactoryMock();

        new Expectations() {{
            Validation.buildDefaultValidatorFactory();
            result = validatorFactoryMock;

            validatorFactoryMock.getValidator();
            result = validatorMock;

            validatorMock.validate(withAny(PojoRequest.class));
            result = prepareConstraintViolations();

            constraintViolationMock.getMessage();
            result = "CorrelationId ID cannot be blank";
        }};

        Exception exception = assertThrows(ConstraintViolationException.class, () -> {
            PojoRequest pojoRequest = preparePojoRequest();
            propertyValidatorImpl.validateFields(pojoRequest);
        });
    }

    @Test
    public void validateFields_withValidPojoRequest_performSuccessfulValidations() {
        prepareValidatorFactoryMock();

        new Expectations() {{
            Validation.buildDefaultValidatorFactory();
            result = validatorFactoryMock;

            validatorFactoryMock.getValidator();
            result = validatorMock;

            validatorMock.validate(withAny(PojoRequest.class));
            result = new HashSet<>();
        }};

        PojoRequest pojoRequest = preparePojoRequest();
        propertyValidatorImpl.validateFields(pojoRequest);

        new VerificationsInOrder() {{
            validatorFactoryMock.getValidator();
            times = 1;

            validatorMock.validate(withAny(PojoRequest.class));
            times = 1;
        }};
    }

    private void prepareValidatorFactoryMock() {
        new MockUp<Validation>() {
            @Mock
            public ValidatorFactory buildDefaultValidatorFactory() {
                return validatorFactoryMock;
            }
        };
    }

    private Set<ConstraintViolation<Object>> prepareConstraintViolations() {
        Set<ConstraintViolation<Object>> constraintViolations = new HashSet<>();
        constraintViolations.add(constraintViolationMock);
        return constraintViolations;
    }

    private PojoRequest preparePojoRequest() {
        return PojoRequest.builder()
                .Id("1")
                .name("Test")
                .CorrelationId("1234")
                .requestId("123")
                .build();
    }
}
