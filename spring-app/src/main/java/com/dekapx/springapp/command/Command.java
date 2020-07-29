package com.dekapx.springapp.command;

@FunctionalInterface
public interface Command<T, R> {
    R execute(T request);
}
