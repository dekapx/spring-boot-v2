package com.dekapx.springboot.designpatterns.servicelocator.command.delete;

import com.dekapx.springboot.designpatterns.servicelocator.command.Command;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeleteCommand implements Command<DeleteRequest, DeleteResponse> {
    @Override
    public DeleteResponse execute(final DeleteRequest request) {
        log.info("DeleteCommand invoked...");
        return null;
    }
}
