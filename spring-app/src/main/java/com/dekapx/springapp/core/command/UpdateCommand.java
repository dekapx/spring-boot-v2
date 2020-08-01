package com.dekapx.springapp.core.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateCommand implements Command<String, String> {
    @Override
    public String execute(String request) {
        return null;
    }
}
