package com.dekapx.springapp.executor;

import com.dekapx.springapp.command.Command;

public interface CommandExecutor {
    void executeCommand(Command command);
}
