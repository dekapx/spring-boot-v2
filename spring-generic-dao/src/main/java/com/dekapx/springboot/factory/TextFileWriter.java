package com.dekapx.springboot.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TextFileWriter implements FileWriter {
    @Override
    public void write(String contents) {
        log.info("Write Text file");
    }

    @Override
    public FileWriterType getType() {
        return FileWriterType.TEXT_FILE_WRITER;
    }
}
