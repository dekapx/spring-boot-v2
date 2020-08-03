package com.dekapx.springboot.core.command;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.dekapx.springboot.core.command.CommandType.DELETE_COMMAND;
import static com.dekapx.springboot.core.command.CommandType.SAVE_COMMAND;
import static com.dekapx.springboot.core.command.CommandType.UPDATE_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommandFactoryITest {
    @Autowired
    private CommandFactory commandFactory;


    @Test
    public void getCommand_withGivenCommandType_returnsCommand() {
        Command saveCommand = commandFactory.getCommand(SAVE_COMMAND);
        assertThat(saveCommand)
                .isNotNull()
                .isInstanceOf(SaveCommand.class);
        saveCommand.execute("Test");

        Command updateCommand = commandFactory.getCommand(UPDATE_COMMAND);
        assertThat(updateCommand)
                .isNotNull()
                .isInstanceOf(UpdateCommand.class);
        updateCommand.execute("Test");

        Command deleteCommand = commandFactory.getCommand(DELETE_COMMAND);
        assertThat(deleteCommand)
                .isNotNull()
                .isInstanceOf(DeleteCommand.class);
        deleteCommand.execute("Test");
    }
}
