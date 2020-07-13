package com.dekapx.springapp.model;

import com.dekapx.springapp.common.FileWriterType;

public interface FileWriter {
    void write(String contents);

    FileWriterType getType();
}
