package com.dekapx.springapp.factory;

import com.dekapx.springapp.common.FileWriterType;
import com.dekapx.springapp.model.FileWriter;

public interface FileWriterFactory {
    FileWriter getFileWriter(FileWriterType type);
}
