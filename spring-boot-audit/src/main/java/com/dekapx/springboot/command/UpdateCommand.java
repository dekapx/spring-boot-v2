package com.dekapx.springboot.command;

import com.dekapx.springboot.enums.CommandType;
import org.springframework.stereotype.Component;

@Component("updateCommand")
public class UpdateCommand implements Command<UpdateRequest, UpdateResponse> {
    @Override
    public UpdateResponse execute(UpdateRequest updateRequest) {
        return null;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.UPDATE;
    }
}
