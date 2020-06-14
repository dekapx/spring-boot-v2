package com.dekapx.springboot.designpatterns.servicelocator.command;

import com.dekapx.springboot.designpatterns.servicelocator.mapper.CommandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

@Component
public class CommandFactoryImpl implements CommandFactory {
    private List<Command> commands;

    @Autowired
    private CommandMapper commandMapper;

    @Autowired
    private CommandFactoryImpl(final List<Command> commands) {
        this.commands = Collections.unmodifiableList(commands);
    }

    @Override
    public Command getCommand(final CommandType commandType) {
        return this.commands.stream()
                .filter(isMatchingType(commandType))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Exception ! Invalid CommandType"));
    }

    private Predicate<Command> isMatchingType(final CommandType commandType) {
        return command -> command.getClass().getTypeName().equals(getType(commandType));
    }

    private String getType(final CommandType commandType) {
        return this.commandMapper.getCommandType(commandType);
    }
}
