package com.dekapx.springboot.command;

import com.dekapx.springboot.enums.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("commandFactory")
public class CommandFactoryImpl implements CommandFactory {

    private final List<Command> commands;

    @Autowired
    public CommandFactoryImpl(final List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public Command getCommand(CommandType type) {
        return commands
                .stream()
                .filter(c -> c.getCommandType().equals(type))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
