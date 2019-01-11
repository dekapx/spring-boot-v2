package com.dekapx.springboot.command;

import com.dekapx.springboot.enums.CommandType;
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
        Command saveCommand = commandFactory.getCommand(CommandType.SAVE);
        Assert.assertEquals(CommandType.SAVE, saveCommand.getCommandType());

        Command authorizeCommand = commandFactory.getCommand(CommandType.AUTHORISE);
        Assert.assertEquals(CommandType.AUTHORISE, authorizeCommand.getCommandType());

        Command updateCommand = commandFactory.getCommand(CommandType.UPDATE);
        Assert.assertEquals(CommandType.UPDATE, updateCommand.getCommandType());
    }
}
