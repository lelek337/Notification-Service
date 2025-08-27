package notification.service.space.repository;

import notification.service.space.model.entity.PushInboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PushInboxRepository extends JpaRepository<PushInboxEntity, UUID> {

    Optional<PushInboxEntity> findByKeyAndValue(String key, String value);
}
