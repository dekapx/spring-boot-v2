package com.dekapx.springapp.factory;

import com.dekapx.springapp.command.Command;
import com.dekapx.springapp.common.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CommandFactoryImpl implements CommandFactory {
    private List<Command> commands;

    @Autowired
    public CommandFactoryImpl(final List<Command> commands) {
        this.commands = new ArrayList<>();
        this.commands.addAll(commands);
    }

    @Override
    public Command getCommand(final CommandType commandType) {
        return this.commands
                .stream()
                .filter(isMatchingCommand(commandType))
                .findFirst()
                .get();
    }

    private Predicate<Command> isMatchingCommand(final CommandType commandType) {
        return command -> command.getClass().getTypeName().equals(commandType.toString());
    }
}
