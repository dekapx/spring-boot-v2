package com.dekapx.springboot.core.command;

@FunctionalInterface
public interface Command<T, R> {
    R execute(T request);
}
