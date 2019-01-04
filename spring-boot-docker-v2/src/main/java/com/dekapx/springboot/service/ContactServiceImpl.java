package com.dekapx.springboot.service;

import com.dekapx.springboot.command.AuthorizeRequest;
import com.dekapx.springboot.command.AuthorizeResponse;
import com.dekapx.springboot.command.Command;
import com.dekapx.springboot.command.SaveRequest;
import com.dekapx.springboot.command.SaveResponse;
import com.dekapx.springboot.domain.ContactEntity;
import com.dekapx.springboot.dto.ContactDto;
import com.dekapx.springboot.repository.ContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("contactService")
public class ContactServiceImpl implements ContactService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    @Qualifier("saveCommand")
    private Command<SaveRequest, SaveResponse> saveCommand;

    @Autowired
    @Qualifier("authorizeCommand")
    private Command<AuthorizeRequest, AuthorizeResponse> authorizeCommand;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ContactServiceHelper helper;

    @Override
    public ContactDto save(final ContactDto dto) {
        final ContactEntity entity = helper.toContactEntity(dto);
        final SaveRequest request = toSaveRequest(contactRepository, entity);
        final SaveResponse<ContactEntity> response = saveCommand.execute(request);
        LOGGER.info("Contact created with ID [{}]...", response.getEntity().getId());
        return helper.toContactDto(response.getEntity());
    }

    @Override
    public ContactDto authorize(final Long id) {
        final AuthorizeRequest request = toAuthorizeRequest(contactRepository, id);
        final AuthorizeResponse response = authorizeCommand.execute(request);
        LOGGER.info("Contact updated with ID [{}]...", response.getEntity().getId());
        return helper.toContactDto((ContactEntity) response.getEntity());
    }

    private SaveRequest toSaveRequest(final ContactRepository repository, final ContactEntity entity) {
        return SaveRequest.builder()
                .repository(repository)
                .entity(entity)
                .build();
    }

    private AuthorizeRequest toAuthorizeRequest(final ContactRepository repository, final Long id) {
        return AuthorizeRequest.builder()
                .repository(repository)
                .id(id)
                .build();
    }
}
