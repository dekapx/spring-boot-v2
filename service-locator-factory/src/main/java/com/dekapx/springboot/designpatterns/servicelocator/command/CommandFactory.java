package com.dekapx.springboot.designpatterns.servicelocator.command;

public interface CommandFactory {
    Command getCommand(CommandType commandType);
}
