package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.command.Command;
import com.dekapx.springboot.command.CommandFactory;
import com.dekapx.springboot.command.SaveRequest;
import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.dto.ContactDto;
import com.dekapx.springboot.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import static com.dekapx.springboot.enums.CommandType.SAVE;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    @Qualifier("commandFactory")
    private CommandFactory commandFactory;

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public void save(ContactDto contactDto) {
        final Command command = commandFactory.getCommand(SAVE);
        final SaveRequest saveRequest = buildRequest(contactDto);
        command.execute(saveRequest);
    }

    private SaveRequest buildRequest(final ContactDto dto) {
        final Contact entity = toEntity(dto);
        return SaveRequest.<Contact>builder()
                .entity(entity)
                .repository(contactRepository)
                .build();
    }

    private Contact toEntity(final ContactDto dto) {
        final Contact entity = new Contact();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
