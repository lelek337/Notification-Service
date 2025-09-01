package notification.service.space.service;

import lombok.RequiredArgsConstructor;
import notification.service.space.model.entity.SmsInboxEntity;
import notification.service.space.repository.SmsInboxRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SmsInboxService {

    private final SmsInboxRepository repository;

    public Optional<SmsInboxEntity> findByKeyAndValue(String key, String value) {
        return repository.findByKeyAndValue(key, value);
    }

    public void saveEvent(String topic, String key, String smsEvent) {

        SmsInboxEntity entity = SmsInboxEntity.builder()
                .topic(topic)
                .key(key)
                .value(smsEvent)
                .processed(false)
                .build();

        repository.save(entity);
    }
}
