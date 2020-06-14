package com.dekapx.springboot.designpatterns.servicelocator.mapper;

import com.dekapx.springboot.designpatterns.servicelocator.command.CommandType;

public interface CommandMapper {
    String getCommandType(CommandType commandType);
}
