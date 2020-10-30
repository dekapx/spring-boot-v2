package com.dekapx.springboot.service;

@FunctionalInterface
public interface FileWriter {
    void write(String contents);
}
