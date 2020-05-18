package com.dekapx.springboot.factory;

public interface FileWriter {
    void write(String contents);

    FileWriterType getType();
}
