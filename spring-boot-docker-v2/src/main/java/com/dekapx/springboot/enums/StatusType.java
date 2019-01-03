package com.dekapx.springboot.enums;

public enum StatusType {
    AUTHORISED("AUTHORISED"),
    PENDING_AUTHORISED("PENDING_AUTHORISED"),
    PENDING_UPDATE_AUTHORISED("PENDING_UPDATE_AUTHORISED");

    private String statusType;

    StatusType(final String statusType) {
        this.statusType = statusType;
    }

    public String toString() {
        return statusType;
    }
}
