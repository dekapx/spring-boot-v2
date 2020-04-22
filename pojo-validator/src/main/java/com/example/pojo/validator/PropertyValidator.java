package com.example.pojo.validator;

public interface PropertyValidator<T> {
    void validateFields(T object);
}
