package com.dekapx.springboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileWriterTest {
    @Autowired
    private FileWriter fileWriter;

    @Test
    void writeContentsToFile() {
        this.fileWriter.write("test");
    }
}