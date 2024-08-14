package com.dekapx.apps.contact.audit;

import com.dekapx.apps.contact.domain.Contact;
import com.dekapx.apps.contact.model.AuditModel;
import com.dekapx.apps.contact.repository.ContactRepository;
import com.dekapx.apps.core.audit.AuditService;
import com.dekapx.apps.core.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.commit.CommitMetadata;
import org.javers.core.diff.Change;
import org.javers.core.diff.changetype.ValueChange;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.repository.jql.JqlQuery;
import org.javers.repository.jql.QueryBuilder;
import org.javers.shadow.Shadow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Slf4j
@Service("contactAuditService")
public class ContactAuditService implements AuditService<Contact> {
    private final ContactRepository repository;
    private final Javers javers;

    @Autowired
    public ContactAuditService(final ContactRepository repository, final Javers javers) {
        this.repository = repository;
        this.javers = javers;
    }

    @Override
    public List<Shadow<Contact>> findShadows(final Long id) {
        final Optional<Contact> optional = this.repository.findById(id);
        final Contact contact = optional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [{}] not found...", id)));
        return this.javers.findShadows(QueryBuilder.byInstance(contact).build());
    }

    @Override
    public List<CdoSnapshot> findSnapshots(final Long id) {
        final Optional<Contact> optional = this.repository.findById(id);
        final Contact contact = optional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [{}] not found...", id)));

        JqlQuery jqlQuery = QueryBuilder.byInstance(contact).build();
        return this.javers.findSnapshots(jqlQuery);
    }

    @Override
    public Changes findChanges(final Long id) {
        final Optional<Contact> optional = this.repository.findById(id);
        final Contact contact = optional.orElseThrow(()
                -> new ResourceNotFoundException(String.format("Contact with ID [{}] not found...", id)));
        final Changes changes = this.javers.findChanges(QueryBuilder.byInstance(contact)
                .withChildValueObjects(true)
                .build());
        log.info(changes.prettyPrint());
        return changes;
    }

    @Override
    public Changes findChanges() {
        final Changes changes = this.javers
                .findChanges(QueryBuilder.byClass(Contact.class)
                        .withChildValueObjects()
                        .build());
        log.info(changes.prettyPrint());
        return changes;
    }

    @Override
    public List<AuditModel> findAuditModels(Long id) {
        final Changes changes = findChanges(id);
        return toAuditModels(changes);
    }

    private List<AuditModel> toAuditModels(final Changes changes) {
        return changes.stream()
                .map(change -> toAuditModel((ValueChange)change))
                .collect(Collectors.toList());
    }

    private AuditModel toAuditModel(final ValueChange valueChange) {
        return AuditModel.builder()
                .propertyName(valueChange.getPropertyName())
                .oldValue(String.valueOf(valueChange.getLeft()))
                .newValue(String.valueOf(valueChange.getRight()))
                .modifiedBy(getModifiedBy(valueChange.getCommitMetadata()))
                .modifiedDate(getModifiedDate(valueChange.getCommitMetadata()))
                .build();
    }

    private String getModifiedBy(final Optional<CommitMetadata> commitMetadataOptional) {
        String modifiedBy = "";
        if (commitMetadataOptional.isPresent()) {
            modifiedBy = commitMetadataOptional.get().getAuthor();
        }
        return modifiedBy;
    }

    private String getModifiedDate(final Optional<CommitMetadata> commitMetadataOptional) {
        String modifiedDate = "";
        if (commitMetadataOptional.isPresent()) {
            modifiedDate = commitMetadataOptional.get().getCommitDate().toString();
        }
        return modifiedDate;
    }
}
