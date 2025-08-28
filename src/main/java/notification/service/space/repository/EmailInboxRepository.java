package notification.service.space.repository;

import notification.service.space.model.entity.EmailInboxEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmailInboxRepository extends JpaRepository<EmailInboxEntity, UUID> {

    Optional<EmailInboxEntity> findByKeyAndValue(String key, String value);

    @Query(value = """
        SELECT e FROM EmailInboxEntity e
        WHERE e.processed = false 
        ORDER BY e.createdAt ASC                
    """)
    List<EmailInboxEntity> findUnprocessed(Pageable pageable);
}
