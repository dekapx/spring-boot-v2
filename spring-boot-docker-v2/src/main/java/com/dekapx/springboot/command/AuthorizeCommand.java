package com.dekapx.springboot.command;

import com.dekapx.springboot.domain.BaseEntity;
import com.dekapx.springboot.enums.StatusType;
import com.dekapx.springboot.repository.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("authorizeCommand")
public class AuthorizeCommand extends AbstractCommand implements Command<AuthorizeRequest, AuthorizeResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizeCommand.class);

    @Override
    public AuthorizeResponse execute(AuthorizeRequest request) {
        final Long id = (Long) request.getId();
        final JpaRepository repository = request.getRepository();
        final BaseEntity entity = findById(id, repository);
        entity.setStatus(getStatus(StatusType.AUTHORISED.toString()));
        repository.save(entity);
        LOGGER.info("Authorize operation completed with SUCCESS for entity [{}] with ID [{}]", entity.getClass().getSimpleName(), entity.getId());
        return toAuthorizeResponse(entity);
    }

    private BaseEntity findById(final Long id, final JpaRepository repository) {
        final Optional<BaseEntity> optionalEntity =  repository.findById(id);
        return optionalEntity.orElseThrow(() -> new ObjectNotFoundException((String.valueOf(id))));
    }

    protected AuthorizeResponse toAuthorizeResponse(final BaseEntity entity) {
        return AuthorizeResponse.builder().entity(entity).build();
    }
}
