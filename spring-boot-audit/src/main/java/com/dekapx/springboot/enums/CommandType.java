package com.dekapx.springboot.enums;

public enum CommandType {
    SAVE("SaveCommand"),
    AUTHORISE("AuthorizeCommand"),
    UPDATE("UpdateCommand");

    private String commandType;

    CommandType(final String commandType) {
        this.commandType = commandType;
    }

    public String toString() {
        return commandType;
    }
}
