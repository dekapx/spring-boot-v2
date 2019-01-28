package com.dekapx.springboot.command.authorize;

import com.dekapx.springboot.command.Command;
import com.dekapx.springboot.enums.CommandType;
import org.springframework.stereotype.Component;

@Component("authorizeCommand")
public class AuthorizeCommand implements Command<AuthorizeRequest, AuthorizeResponse> {

    @Override
    public AuthorizeResponse execute(AuthorizeRequest authorizeRequest) {
        return null;
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.AUTHORISE;
    }
}
