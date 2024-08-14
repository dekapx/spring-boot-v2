package com.dekapx.apps.contact.mapper;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.model.ContactModel;
import com.dekapx.apps.core.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component("contactMapper")
public class ContactMapper implements Mapper<Contact, ContactModel> {
    @Override
    public Contact toEntity(final ContactModel model) {
        final Contact contact = new Contact();
        contact.setFirstName(model.getFirstName());
        contact.setLastName(model.getLastName());
        contact.setEmail(model.getEmail());
        contact.setPhone(model.getPhone());
        return contact;
    }

    @Override
    public ContactModel toModel(final Contact entity) {
        return ContactModel.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();
    }

    @Override
    public void copyProperties(final Contact entity, final ContactModel model) {
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        entity.setPhone(model.getPhone());
    }

    @Override
    public String getType() {
        return Contact.class.getTypeName();
    }
}
