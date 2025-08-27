package notification.service.space.service;

import lombok.RequiredArgsConstructor;
import notification.service.space.model.entity.TelegramInboxEntity;
import notification.service.space.repository.TelegramInboxRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelegramInboxService {

    private final TelegramInboxRepository repository;

    public Optional<TelegramInboxEntity> findByKeyAndValue(String key, String value) {
        return repository.findByKeyAndValue(key, value);
    }

    public void saveEvent(String topic, String key, String telegramEvent) {
        TelegramInboxEntity entity = TelegramInboxEntity.builder()
                .topic(topic)
                .key(key)
                .value(telegramEvent)
                .build();

        repository.save(entity);
    }
}
