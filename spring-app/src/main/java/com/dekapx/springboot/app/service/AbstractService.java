package com.dekapx.springboot.app.service;

import static com.dekapx.springboot.app.util.MessageUtils.getNotNullOrEmptyMessage;
import static org.springframework.util.Assert.hasLength;
import static org.springframework.util.Assert.notNull;

abstract class AbstractService {
    protected void performNullAndEmptyStringValidation(final String attributeName, final String attributeValue) {
        notNull(attributeValue, getNotNullOrEmptyMessage(attributeName));
        hasLength(attributeValue, getNotNullOrEmptyMessage(attributeName));
    }
}
