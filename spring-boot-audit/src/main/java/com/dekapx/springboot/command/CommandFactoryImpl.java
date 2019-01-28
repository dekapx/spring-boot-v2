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
    public Command getCommand(CommandType commandType) {
        return commands
                .stream()
                .filter(command -> command.getCommandType().equals(commandType))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
