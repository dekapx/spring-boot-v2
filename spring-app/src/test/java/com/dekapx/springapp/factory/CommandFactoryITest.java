package com.dekapx.springapp.factory;

import com.dekapx.springapp.command.Command;
import com.dekapx.springapp.command.DeleteCommand;
import com.dekapx.springapp.command.SaveCommand;
import com.dekapx.springapp.command.UpdateCommand;
import com.dekapx.springapp.executor.CommandExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.dekapx.springapp.common.CommandType.DELETE_COMMAND;
import static com.dekapx.springapp.common.CommandType.SAVE_COMMAND;
import static com.dekapx.springapp.common.CommandType.UPDATE_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommandFactoryITest {
    @Autowired
    private CommandFactory commandFactory;

    @Autowired
    private CommandExecutor commandExecutor;

    @Test
    public void getCommand_withGivenCommandType_returnsCommand() {
        Command saveCommand = commandFactory.getCommand(SAVE_COMMAND);
        assertThat(saveCommand)
                .isNotNull()
                .isInstanceOf(SaveCommand.class);
        commandExecutor.executeCommand(saveCommand);

        Command updateCommand = commandFactory.getCommand(UPDATE_COMMAND);
        assertThat(updateCommand)
                .isNotNull()
                .isInstanceOf(UpdateCommand.class);
        commandExecutor.executeCommand(updateCommand);

        Command deleteCommand = commandFactory.getCommand(DELETE_COMMAND);
        assertThat(deleteCommand)
                .isNotNull()
                .isInstanceOf(DeleteCommand.class);
        commandExecutor.executeCommand(deleteCommand);
    }
}
