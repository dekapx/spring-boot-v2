package com.dekapx.springboot.service;

import com.dekapx.springboot.model.Contact;
import com.dekapx.springboot.repository.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    private IGenericDao<Contact> genericDao;

    @Autowired
    public ContactServiceImpl(IGenericDao<Contact> genericDao) {
        this.genericDao = genericDao;
        this.genericDao.setClazz(Contact.class);
    }


    @Override
    public void create(final Contact contact) {
        genericDao.create(contact);
    }
}
