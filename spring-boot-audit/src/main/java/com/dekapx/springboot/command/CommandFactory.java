package com.dekapx.springboot.command;

import com.dekapx.springboot.enums.CommandType;

public interface CommandFactory {
    Command getCommand(CommandType commandType);
}
