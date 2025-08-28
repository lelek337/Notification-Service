package notification.service.space.repository;

import notification.service.space.model.entity.SmsInboxEntity;
import notification.service.space.model.entity.TelegramInboxEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TelegramInboxRepository extends JpaRepository<TelegramInboxEntity, UUID> {

    Optional<TelegramInboxEntity> findByKeyAndValue(String key, String value);

    @Query(value = """
        SELECT t FROM TelegramInboxEntity t
        WHERE t.processed = false 
        ORDER BY t.createdAt ASC                
    """)
    List<TelegramInboxEntity> findUnprocessed(Pageable pageable);
}
