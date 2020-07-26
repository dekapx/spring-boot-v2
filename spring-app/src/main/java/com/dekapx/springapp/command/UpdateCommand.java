package com.dekapx.springapp.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateCommand implements Command {
    @Override
    public void execute() {
        log.info("UpdateCommand executed...");
    }
}
