package com.dekapx.springboot.service.impl;

import com.dekapx.springboot.service.FileWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Slf4j
@Primary
@Service
public class DefaultFileWriter implements FileWriter {
    @Override
    public void write(String contents) {
        log.info("Default FileWriter implementation...");
    }
}
