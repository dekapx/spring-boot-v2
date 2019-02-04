package com.dekapx.springboot.command;

import com.dekapx.springboot.contact.domain.BaseEntity;
import com.dekapx.springboot.contact.domain.Status;
import com.dekapx.springboot.contact.repository.StatusRepository;
import com.dekapx.springboot.enums.CommandType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component("saveCommand")
public class SaveCommand implements Command<SaveRequest, SaveResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveCommand.class);

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public SaveResponse execute(SaveRequest saveRequest) {
        LOGGER.info("executing save command...");
        BaseEntity entity = saveRequest.getEntity();
        entity.setStatus(getStatus());

        final JpaRepository jpaRepository = saveRequest.getRepository();
        entity = (BaseEntity) jpaRepository.save(saveRequest.getEntity());
        return SaveResponse.builder()
                .entity(entity)
                .build();
    }

    private Status getStatus() {
        return statusRepository.findByStatus("PENDING_AUTHORISED");
    }

    @Override
    public CommandType getCommandType() {
        return CommandType.SAVE;
    }
}
