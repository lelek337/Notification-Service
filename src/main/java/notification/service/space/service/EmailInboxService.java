package notification.service.space.service;

import lombok.RequiredArgsConstructor;
import notification.service.space.model.entity.EmailInboxEntity;
import notification.service.space.repository.EmailInboxRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailInboxService {

    private final EmailInboxRepository repository;

    public Optional<EmailInboxEntity> findByKeyAndValue(String key, String value) {
        return repository.findByKeyAndValue(key, value);
    }

    public void saveEvent(String topic, String key, String emailEvent) {
        EmailInboxEntity entity = EmailInboxEntity.builder()
                .topic(topic)
                .key(key)
                .value(emailEvent)
                .build();

        repository.save(entity);
    }
}
