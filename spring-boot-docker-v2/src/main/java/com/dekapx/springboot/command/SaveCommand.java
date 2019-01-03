package com.dekapx.springboot.command;

import com.dekapx.springboot.domain.BaseEntity;
import com.dekapx.springboot.domain.StatusEntity;
import com.dekapx.springboot.enums.StatusType;
import com.dekapx.springboot.repository.StatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveCommand implements Command<SaveRequest, SaveResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveCommand.class);

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public SaveResponse execute(final SaveRequest request) {
        final BaseEntity entity = request.getEntity();
        final JpaRepository repository = request.getRepository();
        entity.setStatus(getStatus());
        repository.save(entity);
        LOGGER.info("Save operation completed with SUCCESS for entity [{}] with ID [{}]", entity.getClass().getSimpleName(), entity.getId());
        return toSaveResponse(entity);
    }

    private StatusEntity getStatus() {
        return statusRepository.findByStatus(StatusType.PENDING_AUTHORISED.toString());
    }

    private SaveResponse toSaveResponse(final BaseEntity entity) {
        return SaveResponse.builder().entity(entity).build();
    }
}
