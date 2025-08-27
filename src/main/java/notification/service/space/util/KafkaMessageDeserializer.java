package notification.service.space.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Log4j2
@Component
@RequiredArgsConstructor
public class KafkaMessageDeserializer {

    private final ObjectMapper objectMapper;

    public <T> T deserialize(byte[] data, Class<T> targetClass) {
        try {
            String jsonString = new String(data, StandardCharsets.UTF_8);
            log.debug("Десериализуем {} из JSON: {}", targetClass.getSimpleName(), jsonString);
            return objectMapper.readValue(jsonString, targetClass);
        } catch (Exception e) {
            log.error("Ошибка десериализации в {}: {}", targetClass.getSimpleName(), e.getMessage(), e);
            throw new RuntimeException("Не удалось десериализовать " + targetClass.getSimpleName(), e);
        }
    }
}
