package com.dekapx.springboot.designpatterns.servicelocator.command.save;

import com.dekapx.springboot.designpatterns.servicelocator.command.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SaveCommand implements Command<SaveRequest, SaveResponse> {
    @Override
    public SaveResponse execute(final SaveRequest request) {
        log.info("SaveCommand invoked...");
        return null;
    }
}
