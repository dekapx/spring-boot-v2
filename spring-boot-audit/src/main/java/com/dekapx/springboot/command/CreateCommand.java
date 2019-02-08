package com.dekapx.springboot.command;

import com.dekapx.springboot.contact.domain.StatusEntity;
import com.dekapx.springboot.contact.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component("saveCommand")
public class CreateCommand implements Command<CreateRequest, CreateResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateCommand.class);

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public CreateResponse execute(CreateRequest createRequest) {
        LOGGER.info("executing create command...");
        return null;
    }

    private StatusEntity getStatus() {
        return statusRepository.findByStatus("PENDING_AUTHORISED");
    }

    @Override
    public String getCommandType() {
        return CreateCommand.class.getTypeName();
    }
}
