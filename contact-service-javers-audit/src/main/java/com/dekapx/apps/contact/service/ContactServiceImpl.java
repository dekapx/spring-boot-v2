package com.dekapx.apps.contact.service;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.model.ContactModel;
import com.dekapx.apps.contact.repository.ContactRepository;
import com.dekapx.apps.contact.specification.ContactSpecification;
import com.dekapx.apps.core.exception.NoContentException;
import com.dekapx.apps.core.exception.ResourceAlreadyExistsException;
import com.dekapx.apps.core.exception.ResourceNotFoundException;
import com.dekapx.apps.core.mapper.Mapper;
import com.dekapx.apps.core.mapper.MapperFactory;
import com.dekapx.apps.core.search.SearchCriteria;
import com.dekapx.apps.core.search.SearchOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static com.dekapx.apps.core.search.SearchOperation.EQUAL;
import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.nonNull;

@Slf4j
@Service
@Transactional
public class ContactServiceImpl implements ContactService {
    private MapperFactory mapperFactory;
    private ContactRepository repository;
    private Mapper<Contact, ContactModel> mapper;

    @Autowired
    public ContactServiceImpl(final MapperFactory mapperFactory, final ContactRepository repository) {
        this.mapperFactory = mapperFactory;
        this.repository = repository;
        this.mapper = this.mapperFactory.getMapper(Contact.class);
    }

    @Override
    public List<ContactModel> findAll() {
        final List<ContactModel> contacts = new ArrayList<>();
        this.repository.findAll().forEach(contact -> contacts.add(this.mapper.toModel(contact)));
        return Optional.of(contacts).filter(c -> c.size() > 0)
                .orElseThrow(() -> new NoContentException("No contents found..."));
    }

    @Override
    public ContactModel findById(final Long id) {
        checkArgument(nonNull(id), "Contact ID must not be null or empty.");
        final var contact = findByIdFunction.apply(id);
        return this.mapper.toModel(contact);
    }

    private Function<Long, Contact> findByIdFunction = (id) -> {
        final var contactOptional = this.repository.findById(id);
        return contactOptional.orElseThrow(
                () -> new ResourceNotFoundException(String.format("Contact with ID [%d] not found.", id)));
    };

    @Override
    public ContactModel findBySpecification(final Specification<Contact> specification) {
        final var contactOptional = this.repository.findOne(specification);
        final var contact = contactOptional.orElseThrow(
                () -> new ResourceNotFoundException("Contact not found for specification..."));
        return this.mapper.toModel(contact);
    }

    @Override
    public ContactModel save(final ContactModel model) {
        checkForDuplicate(model);
        var contact = this.mapper.toEntity(model);
        contact = this.repository.save(contact);
        log.info("Contact created with ID [{}]", contact.getId());
        return this.mapper.toModel(contact);
    }

    private void checkForDuplicate(final ContactModel model) {
        final ContactSpecification specification = new ContactSpecification();
        specification.addSearchCriteria(buildSearchCriteria("firstName", EQUAL, model.getFirstName()));
        specification.addSearchCriteria(buildSearchCriteria("lastName", EQUAL, model.getLastName()));
        specification.addSearchCriteria(buildSearchCriteria("email", EQUAL, model.getEmail()));
        if (this.repository.findOne(specification).isPresent()) {
            throw new ResourceAlreadyExistsException("Contact already exists...");
        }
    }

    private SearchCriteria buildSearchCriteria(final String key, final SearchOperation searchOperation, final Object value) {
        return SearchCriteria.builder()
                .key(key)
                .operation(searchOperation)
                .value(value)
                .build();
    }

    @Override
    public ContactModel update(final Long id, final ContactModel model) {
        checkArgument(nonNull(id), "Contact ID must not be null or empty.");

        final var contact = findByIdFunction.apply(id);
        this.mapper.copyProperties(contact, model);
        final var contactUpdated = this.repository.save(contact);
        log.info("Contact updated with ID [{}]", contactUpdated.getId());
        return this.mapper.toModel(contactUpdated);
    }

    @Override
    public void delete(final Long id) {
        checkArgument(nonNull(id), "Contact ID must not be null or empty.");

        final var contactOptional = this.repository.findById(id);
        final var contact = contactOptional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [%d] not found.", id)));
        this.repository.delete(contact);
        log.info("Contact with ID [{}}] is deleted successfully... ", id);
    }
}
