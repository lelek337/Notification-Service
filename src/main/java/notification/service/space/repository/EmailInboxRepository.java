package notification.service.space.repository;

import notification.service.space.model.entity.EmailInboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EmailInboxRepository extends JpaRepository<EmailInboxEntity, UUID> {

    Optional<EmailInboxEntity> findByKeyAndValue(String key, String value);
}
