package com.dekapx.springboot.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class XmlFileWriter implements FileWriter {
    @Override
    public void write(String contents) {
        log.info("Write Xml file...");
    }

    @Override
    public FileWriterType getType() {
        return FileWriterType.XML_FILE_WRITER;
    }
}
