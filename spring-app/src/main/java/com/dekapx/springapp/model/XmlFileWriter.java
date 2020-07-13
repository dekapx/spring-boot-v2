package com.dekapx.springapp.model;

import com.dekapx.springapp.common.FileWriterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class XmlFileWriter implements FileWriter {
    @Override
    public void write(String contents) {
        log.info("XmlFileWriter invoked...");
    }

    @Override
    public FileWriterType getType() {
        return FileWriterType.XML_FILE_WRITER;
    }
}
