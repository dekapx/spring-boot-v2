package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.command.CommandFactory;
import com.dekapx.springboot.contact.dto.ContactDto;
import com.dekapx.springboot.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    @Qualifier("commandFactory")
    private CommandFactory commandFactory;

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Override
    public void save(ContactDto contactDto) {
    }
}
