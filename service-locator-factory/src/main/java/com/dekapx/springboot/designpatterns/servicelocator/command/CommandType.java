package com.dekapx.springboot.designpatterns.servicelocator.command;

public enum CommandType {
    SAVE("save"), UPDATE("update"), DELETE("delete");

    private String command;
    CommandType(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
