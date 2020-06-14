package com.dekapx.springboot.designpatterns.servicelocator.command;

import com.dekapx.springboot.designpatterns.servicelocator.command.save.SaveCommand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CommandFactoryTest {
    @Autowired
    private CommandFactory commandFactory;

    @Test
    public void getCommand_withCommandType_returnCommandObject() {
        Command command = commandFactory.getCommand(CommandType.SAVE);
        assertThat(command)
                .isNotNull()
                .isInstanceOf(SaveCommand.class);
    }

    @Test
    public void getCommand_withNull_throwsResourceNotFoundException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            commandFactory.getCommand(null);
        });
        String expectedMessage = "Exception ! Invalid CommandType";
        String actualMessage = exception.getMessage();

        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
