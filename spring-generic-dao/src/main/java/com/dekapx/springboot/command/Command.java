package com.dekapx.springboot.command;

public interface Command<T, R> {
    R execute(T request);
}
