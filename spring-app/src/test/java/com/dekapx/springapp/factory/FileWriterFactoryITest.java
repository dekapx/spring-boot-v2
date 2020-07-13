package com.dekapx.springapp.factory;

import com.dekapx.springapp.common.FileWriterType;
import com.dekapx.springapp.model.DummyFileWriter;
import com.dekapx.springapp.model.FileWriter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FileWriterFactoryITest {
    @Autowired
    private FileWriterFactory fileWriterFactory;

    @Test
    public void getFileWriter_withGivenType_returnFileWriter() {
        FileWriter fileWriter = fileWriterFactory.getFileWriter(FileWriterType.DUMMY_FILE_WRITER);
        assertThat(fileWriter)
                .isNotNull()
                .isInstanceOf(DummyFileWriter.class);
    }
}
