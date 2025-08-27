package notification.service.space.repository;

import notification.service.space.model.entity.SmsInboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SmsInboxRepository extends JpaRepository<SmsInboxEntity, UUID> {
    Optional<SmsInboxEntity> findByKeyAndValue(String key, String value);
}
