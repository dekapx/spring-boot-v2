package com.dekapx.springboot.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class FileWriterFactoryImpl implements FileWriterFactory {
    private List<FileWriter> fileWriters;

    @Autowired
    public FileWriterFactoryImpl(List<FileWriter> fileWriters) {
        this.fileWriters = new ArrayList<>(fileWriters.size());
        this.fileWriters.addAll(fileWriters);
    }

    @Override
    public FileWriter getFileWriter(FileWriterType type) {
        return fileWriters.stream()
                .filter(isMatchingType(type))
                .findFirst().get();
    }

    private Predicate<FileWriter> isMatchingType(FileWriterType type) {
        return fileWriter -> fileWriter.getType().equals(type);
    }
}
