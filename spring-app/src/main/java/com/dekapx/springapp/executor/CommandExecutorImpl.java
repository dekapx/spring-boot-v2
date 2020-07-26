package com.dekapx.springapp.executor;

import com.dekapx.springapp.command.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CommandExecutorImpl implements CommandExecutor {
    @Override
    public void executeCommand(final Command command) {
        command.execute();
    }
}
