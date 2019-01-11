package com.dekapx.springboot.command;

import com.dekapx.springboot.enums.CommandType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("commandFactory")
public class CommandFactoryImpl implements CommandFactory {
    @Autowired
    @Qualifier("saveCommand")
    private Command saveCommand;

    @Autowired
    @Qualifier("authorizeCommand")
    private Command authorizeCommand;

    @Autowired
    @Qualifier("updateCommand")
    private Command updateCommand;

    public Command getCommand(final CommandType commandType) {
        Command command = null;
        switch (commandType) {
            case SAVE:
                command = saveCommand;
                break;
            case AUTHORISE:
                command = authorizeCommand;
                break;
            case UPDATE:
                command = updateCommand;
                break;
            default:
                throw new CommandNotFoundException("Command not found");
        }
        return command;
    }
}
