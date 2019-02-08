package com.dekapx.springboot.command;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CommandFactoryTest {
    @Autowired
    @Qualifier("commandFactory")
    private CommandFactory commandFactory;

    @Test
    public void getCommand_withCommandType_loadCommand() {
        Command command = commandFactory.getCommand(CreateCommand.class);
        Assert.assertEquals(CreateCommand.class.getTypeName(), command.getCommandType());
    }
}
