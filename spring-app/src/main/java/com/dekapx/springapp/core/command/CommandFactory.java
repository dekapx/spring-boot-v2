package com.dekapx.springapp.core.command;

public interface CommandFactory {
    Command getCommand(CommandType commandType);
}
