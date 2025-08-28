package notification.service.space.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import notification.service.space.model.entity.TelegramInboxEntity;
import notification.service.space.repository.TelegramInboxRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class TelegramSchedulerService {

    private final TelegramInboxRepository repository;

    @Value("${inbox.telegram-scheduler.batch-size}")
    private int batchSize;

    @Scheduled(fixedDelayString = "${inbox.telegram-scheduler.delay-ms}")
    public void process() {
        log.debug("TelegramSchedulerService: старт обаботки");

        int page = 0;
        List<TelegramInboxEntity> messages;

        do {
            Pageable pageable = PageRequest.of(page, batchSize);
            messages = repository.findUnprocessed(pageable);

            for (TelegramInboxEntity msg : messages) {
                try {
                    log.info("Обработано событие: Key: {}, Payload: {}, topic: {}", msg.getKey(), msg.getValue(), msg.getTopic());
                    msg.setProcessed(true);
                    repository.save(msg);
                } catch (Exception e) {
                    msg.setAttempt(msg.getAttempt() + 1);
                    repository.save(msg);
                }
            }
            page++;
        } while (!messages.isEmpty());
    }
}
