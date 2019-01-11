package com.dekapx.springboot.command;

import com.dekapx.springboot.enums.CommandType;

public interface Command<T, R> {
    R execute (T t);

    CommandType getCommandType();
}
