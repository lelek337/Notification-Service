package notification.service.space.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import notification.service.space.service.EmailInboxService;
import notification.service.space.service.PushInboxService;
import notification.service.space.service.SmsInboxService;
import notification.service.space.service.TelegramInboxService;
import notification.service.space.util.KafkaMessageDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final KafkaMessageDeserializer deserializer;
    private final SmsInboxService smsInboxService;
    private final PushInboxService pushInboxService;
    private final EmailInboxService emailInboxService;
    private final TelegramInboxService telegramInboxService;

    @KafkaListener(topics = "${spring.kafka.topic.sms-events}")
    public void smsEventsConsume(ConsumerRecord<String, byte[]> event) {
        logEventInfo(event);
        try {
            String smsEvent = deserializer.deserialize(event.value(), String.class);

            if (smsInboxService.findByKeyAndValue(event.key(), smsEvent).isPresent()) {
                return;
            }

            smsInboxService.saveEvent(event.topic(), event.key(), smsEvent);
        } catch (Exception e) {
            logEventError(e);
        }
    }

    @KafkaListener(topics = "${spring.kafka.topic.push-events}")
    public void pushEventsConsume(ConsumerRecord<String, byte[]> event) {
        logEventInfo(event);
        try {
            String pushEvent = deserializer.deserialize(event.value(), String.class);

            if (pushInboxService.findByKeyAndValue(event.key(), pushEvent).isPresent()) {
                return;
            }

            pushInboxService.saveEvent(event.topic(), event.key(), pushEvent);
        } catch (Exception e) {
            logEventError(e);
        }
    }

    @KafkaListener(topics = "${spring.kafka.topic.email-events}")
    public void emailEventsConsume(ConsumerRecord<String, byte[]> event) {
        logEventInfo(event);
        try {
            String emailEvent = deserializer.deserialize(event.value(), String.class);

            if (emailInboxService.findByKeyAndValue(event.key(), emailEvent).isPresent()) {
                return;
            }

            emailInboxService.saveEvent(event.topic(), event.key(), emailEvent);
        } catch (Exception e) {
            logEventError(e);
        }
    }

    @KafkaListener(topics = "${spring.kafka.topic.email-events}")
    public void telegramEventsConsume(ConsumerRecord<String, byte[]> event) {
        logEventInfo(event);
        try {
            String telegramEvent = deserializer.deserialize(event.value(), String.class);

            if (telegramInboxService.findByKeyAndValue(event.key(), telegramEvent).isPresent()) {
                return;
            }

            telegramInboxService.saveEvent(event.topic(), event.key(), telegramEvent);
        } catch (Exception e) {
            logEventError(e);
        }
    }

    private void logEventError(Exception e) {
        log.error("Критическая ошибка при обработке события {}", e.getMessage(), e);
    }

    private void logEventInfo(ConsumerRecord<String,byte[]> event) {
        log.info("Обрабатывается сообщение из топика: {}, offset: {}", event.topic(), event.offset());
    }
}
