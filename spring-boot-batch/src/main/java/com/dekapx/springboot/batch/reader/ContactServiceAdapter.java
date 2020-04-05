package com.dekapx.springboot.batch.reader;

import com.dekapx.springboot.batch.model.Contact;

import java.util.List;

public interface ContactServiceAdapter {
    List<Contact> loadPendingContacts();
}
