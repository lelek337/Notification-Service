package notification.service.space.repository;

import notification.service.space.model.entity.PushInboxEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PushInboxRepository extends JpaRepository<PushInboxEntity, UUID> {

    Optional<PushInboxEntity> findByKeyAndValue(String key, String value);

    @Query(value = """
        SELECT p FROM PushInboxEntity p
        WHERE p.processed = false
        ORDER BY p.createdAt ASC
    """)
    List<PushInboxEntity> findUnprocessed(Pageable pageable);
}
