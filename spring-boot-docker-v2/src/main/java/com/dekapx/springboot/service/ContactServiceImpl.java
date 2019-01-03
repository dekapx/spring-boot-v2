package com.dekapx.springboot.service;

import com.dekapx.springboot.command.SaveCommand;
import com.dekapx.springboot.command.SaveRequest;
import com.dekapx.springboot.command.SaveResponse;
import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.dto.ContactDto;
import com.dekapx.springboot.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private SaveCommand saveCommand;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactServiceHelper helper;

    @Override
    public void save(final ContactDto dto) {
        final ContactEntity entity = helper.toContactEntity(dto);
        final SaveRequest request = toSaveRequest(contactRepository, entity);
        final SaveResponse<ContactEntity> response = saveCommand.execute(request);
        LOGGER.info("New contact created with ID [{}]...", response.getEntity().getId());
    }

    private SaveRequest toSaveRequest(final ContactRepository repository, final ContactEntity entity) {
        return SaveRequest.builder()
                .repository(repository)
                .entity(entity)
                .build();
    }
}
