package notification.service.space.repository;

import notification.service.space.model.entity.SmsInboxEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SmsInboxRepository extends JpaRepository<SmsInboxEntity, UUID> {
    Optional<SmsInboxEntity> findByKeyAndValue(String key, String value);

    @Query(value = """
        SELECT s FROM SmsInboxEntity s
        WHERE s.processed = false 
        ORDER BY s.createdAt ASC
    """)
    List<SmsInboxEntity> findUnprocessed(Pageable pageable);
}
