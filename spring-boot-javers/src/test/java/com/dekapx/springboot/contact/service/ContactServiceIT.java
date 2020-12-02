package com.dekapx.springboot.contact.service;

import com.dekapx.springboot.contact.domain.Contact;
import com.dekapx.springboot.contact.dto.AddressDto;
import com.dekapx.springboot.contact.dto.ContactDto;
import org.javers.core.Changes;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.shadow.Shadow;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ContactServiceIT {
    @Autowired
    private ContactService contactService;

    @Test
    public void createNewContact() {
        ContactDto dto = saveContact();
        updateContactEmail(dto);
        updateContactPhone(dto);
        updateContactAddress(dto);
        updateContactZipcode(dto);
        findAudit(dto);
//        deleteContact(dto.getId());
    }

    private ContactDto saveContact() {
        ContactDto dto = this.contactService.save(buildContactDto());
        assertThat(dto.getId()).isNotNull();
        assertThat(dto.getEmail()).isEqualTo("test@mydomain.com");
        assertThat(dto.getPhone()).isEqualTo("+1 123 456 7890");
        return dto;
    }

    private void updateContactEmail(ContactDto dto) {
        dto.setEmail("test@mydomain.ie");
        dto = this.contactService.update(dto);
        assertThat(dto.getEmail()).isEqualTo("test@mydomain.ie");
    }

    private void updateContactPhone(ContactDto dto) {
        dto.setPhone("+353 89 999 8888");
        dto = this.contactService.update(dto);
        assertThat(dto.getPhone()).isEqualTo("+353 89 999 8888");
    }

    private void updateContactAddress(ContactDto dto) {
        dto.getAddressDto().setHouseNo("2121");
        dto.getAddressDto().setStreet("El Camino Real");
        dto = this.contactService.update(dto);
        assertThat(dto.getPhone()).isEqualTo("+353 89 999 8888");
    }

    private void updateContactZipcode(ContactDto dto) {
        dto.getAddressDto().setZipcode("94404");
        dto = this.contactService.update(dto);
        assertThat(dto.getPhone()).isEqualTo("+353 89 999 8888");
    }

    private void deleteContact(Long id) {
        this.contactService.delete(id);
    }

    private void findAudit(ContactDto dto) {
        List<Shadow<Contact>> shadows = this.contactService.findShadows(dto);
        assertThat(shadows).isNotNull();

        List<CdoSnapshot> snapshots = this.contactService.findSnapshots(dto);
        assertThat(snapshots).isNotNull();

        Changes changes = this.contactService.findChanges();
        assertThat(changes).isNotNull();
    }

    private ContactDto buildContactDto() {
        AddressDto addressDto = buildAddressDto();
        return ContactDto.builder()
                .firstName("Test")
                .lastName("User")
                .email("test@mydomain.com")
                .phone("+1 123 456 7890")
                .addressDto(buildAddressDto())
                .build();
    }

    private AddressDto buildAddressDto() {
        return AddressDto.builder()
                .houseNo("1830")
                .street("Gateway Drive")
                .city("San Mateo")
                .county("CA")
                .zipcode("94403")
                .country("United States")
                .build();
    }
}
