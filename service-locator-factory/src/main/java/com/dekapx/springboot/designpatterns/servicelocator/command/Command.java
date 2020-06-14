package com.dekapx.springboot.designpatterns.servicelocator.command;

@FunctionalInterface
public interface Command<T, R> {
    R execute(T request);
}
