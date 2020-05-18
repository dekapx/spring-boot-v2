package com.dekapx.springboot.factory;

public interface FileWriterFactory {
    FileWriter getFileWriter(FileWriterType type);
}
