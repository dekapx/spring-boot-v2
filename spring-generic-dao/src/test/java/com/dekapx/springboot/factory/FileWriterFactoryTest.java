package com.dekapx.springboot.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FileWriterFactoryTest {
    @Autowired
    private FileWriterFactory fileWriterFactory;

    @Test
    public void getFileWriter_withGivenType_returnFileWriter() {
        FileWriter fileWriter = fileWriterFactory.getFileWriter(FileWriterType.CSV_FILE_WRITER);
        assertThat(fileWriter)
                .isNotNull()
                .isInstanceOf(CsvFileWriter.class);
    }
}
