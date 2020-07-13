package com.dekapx.springapp.model;

import com.dekapx.springapp.common.FileWriterType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.dekapx.springapp.common.FileWriterType.DUMMY_FILE_WRITER;

@Slf4j
@Component
public class DummyFileWriter implements FileWriter {
    @Override
    public void write(String contents) {

    }

    @Override
    public FileWriterType getType() {
        return DUMMY_FILE_WRITER;
    }
}
