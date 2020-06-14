package com.dekapx.springboot.designpatterns.servicelocator.command.update;

import com.dekapx.springboot.designpatterns.servicelocator.command.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UpdateCommand implements Command<UpdateRequest, UpdateResponse> {
    @Override
    public UpdateResponse execute(final UpdateRequest request) {
        log.info("UpdateCommand invoked...");
        return null;
    }
}
