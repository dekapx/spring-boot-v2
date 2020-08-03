package com.dekapx.springboot.app.util;

public class MessageUtils {
    public static String getNotNullOrEmptyMessage(final String argName) {
        return String.format("%s must not be null or empty.", argName);
    }
}
