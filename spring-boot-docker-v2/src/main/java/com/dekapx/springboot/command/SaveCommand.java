package com.dekapx.springboot.command;

import com.dekapx.springboot.domain.BaseEntity;
import com.dekapx.springboot.enums.StatusType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("saveCommand")
public class SaveCommand extends AbstractCommand implements Command<SaveRequest, SaveResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveCommand.class);

    @Override
    public SaveResponse execute(final SaveRequest request) {
        final BaseEntity entity = request.getEntity();
        final JpaRepository repository = request.getRepository();
        entity.setStatus(getStatus(StatusType.PENDING_AUTHORISED.toString()));
        repository.save(entity);
        LOGGER.info("Save operation completed with SUCCESS for entity [{}] with ID [{}]", entity.getClass().getSimpleName(), entity.getId());
        return toSaveResponse(entity);
    }

    protected SaveResponse toSaveResponse(final BaseEntity entity) {
        return SaveResponse.builder().entity(entity).build();
    }
}
