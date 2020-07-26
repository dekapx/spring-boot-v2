package com.dekapx.springapp.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaveCommand implements Command {
    @Override
    public void execute() {
        log.info("SaveCommand executed...");
    }

    public static void main(String[] args) {
        System.out.println(SaveCommand.class.getTypeName());
    }
}
