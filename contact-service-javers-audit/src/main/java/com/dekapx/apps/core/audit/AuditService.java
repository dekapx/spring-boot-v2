package com.dekapx.apps.core.audit;

import com.dekapx.apps.contact.model.AuditModel;
import org.javers.core.Changes;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.shadow.Shadow;

import java.util.List;

public interface AuditService<E> {
    List<Shadow<E>> findShadows(Long id);

    List<CdoSnapshot> findSnapshots(Long id);

    Changes findChanges(Long id);

    Changes findChanges();

    List<AuditModel> findAuditModels(Long id);
}
