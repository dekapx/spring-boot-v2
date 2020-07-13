package com.dekapx.springapp.model;

import com.dekapx.springapp.common.FileWriterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CsvFileWriter implements FileWriter {
    @Override
    public void write(final String contents) {
        log.info("CsvFileWriter invoked...");
    }

    @Override
    public FileWriterType getType() {
        return FileWriterType.CSV_FILE_WRITER;
    }
}
