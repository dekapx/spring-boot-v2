package com.dekapx.springboot.command;

import com.dekapx.springboot.enums.CommandType;
import org.springframework.stereotype.Component;

@Component("saveCommand")
public class SaveCommand implements Command<SaveRequest, SaveResponse> {
    @Override
    public SaveResponse execute(SaveRequest saveRequest) {
        return null;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.SAVE;
    }
}
