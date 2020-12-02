package com.dekapx.springboot.contact.convertor;

import com.dekapx.springboot.contact.domain.Address;
import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.dto.AddressDto;
import com.dekapx.springboot.contact.dto.ContactDto;
import com.dekapx.springboot.core.convertor.Convertor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class ContactConvertor implements Convertor<Contact, ContactDto> {
    @Override
    public Contact toEntity(final ContactDto dto) {
        final Contact contact = new Contact();
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        contact.setAddress(toEntity(contact, dto.getAddressDto()));
        return contact;
    }

    private Address toEntity(final Contact contact, final AddressDto dto) {
        final Address address = new Address();
        address.setHouseNo(dto.getHouseNo());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCounty(dto.getCounty());
        address.setZipcode(dto.getZipcode());
        address.setCountry(dto.getCountry());
        address.setContact(contact);
        return address;
    }

    @Override
    public ContactDto toDto(final Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .firstName(contact.getFirstName())
                .lastName(contact.getLastName())
                .email(contact.getEmail())
                .phone(contact.getPhone())
                .addressDto(toEntity(contact.getAddress()))
                .build();
    }

    private AddressDto toEntity(final Address address) {
        return AddressDto.builder()
                .houseNo(address.getHouseNo())
                .street(address.getStreet())
                .city(address.getCity())
                .county(address.getCounty())
                .zipcode(address.getZipcode())
                .country(address.getCountry())
                .build();
    }

    @Override
    public void copyAttributes(final Contact contact, final ContactDto dto) {
        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setEmail(dto.getEmail());
        contact.setPhone(dto.getPhone());
        copyAttributes(contact.getAddress(), dto.getAddressDto());
    }

    private void copyAttributes(final Address address, final AddressDto dto) {
        address.setHouseNo(dto.getHouseNo());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setCounty(dto.getCounty());
        address.setZipcode(dto.getZipcode());
        address.setCountry(dto.getCountry());
    }
}
