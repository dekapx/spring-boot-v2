package com.dekapx.springboot.command;

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
    public Command getCommand(final Class clazz) {
        return commands
                .stream()
                .filter(c -> c.getCommandType().equals(clazz.getTypeName()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
