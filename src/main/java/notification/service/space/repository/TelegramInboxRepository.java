package notification.service.space.repository;

import notification.service.space.model.entity.SmsInboxEntity;
import notification.service.space.model.entity.TelegramInboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TelegramInboxRepository extends JpaRepository<TelegramInboxEntity, UUID> {

    Optional<TelegramInboxEntity> findByKeyAndValue(String key, String value);
}
