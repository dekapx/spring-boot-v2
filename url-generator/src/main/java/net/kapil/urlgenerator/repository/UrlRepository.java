package net.kapil.urlgenerator.repository;

import net.kapil.urlgenerator.domain.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {

    @Query("SELECT u FROM UrlEntity u WHERE u.originalUrl = :originalUrl")
    Optional<UrlEntity> findByUrl(@Param("originalUrl") String originalUrl);

}
