package com.dekapx.springboot.core.command;

public interface CommandFactory {
    Command getCommand(CommandType commandType);
}
