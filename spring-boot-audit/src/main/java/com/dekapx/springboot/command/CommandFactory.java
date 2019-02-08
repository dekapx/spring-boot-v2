package com.dekapx.springboot.command;

public interface CommandFactory {
    Command getCommand(Class clazz);
}
