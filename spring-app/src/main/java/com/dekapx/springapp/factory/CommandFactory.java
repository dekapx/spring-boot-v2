package com.dekapx.springapp.factory;

import com.dekapx.springapp.command.Command;
import com.dekapx.springapp.common.CommandType;

public interface CommandFactory {
    Command getCommand(CommandType commandType);
}
