package com.dekapx.springapp.core.command;

@FunctionalInterface
public interface Command<T, R> {
    R execute(T request);
}
