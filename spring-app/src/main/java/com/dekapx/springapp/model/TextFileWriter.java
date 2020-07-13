package com.dekapx.springapp.model;

import com.dekapx.springapp.common.FileWriterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TextFileWriter implements FileWriter {
    @Override
    public void write(String contents) {
        log.info("TextFileWriter invoked...");
    }

    @Override
    public FileWriterType getType() {
        return FileWriterType.TEXT_FILE_WRITER;
    }
}
