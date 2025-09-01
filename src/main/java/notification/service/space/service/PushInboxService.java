package notification.service.space.service;

import lombok.RequiredArgsConstructor;
import notification.service.space.model.entity.PushInboxEntity;
import notification.service.space.repository.PushInboxRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PushInboxService {

    private final PushInboxRepository repository;

    public Optional<PushInboxEntity> findByKeyAndValue(String key, String value) {
        return repository.findByKeyAndValue(key, value);
    }

    public void saveEvent(String topic, String key, String pushEvent) {
        PushInboxEntity entity =  PushInboxEntity.builder()
                .topic(topic)
                .key(key)
                .value(pushEvent)
                .processed(false)
                .build();

        repository.save(entity);
    }
}
