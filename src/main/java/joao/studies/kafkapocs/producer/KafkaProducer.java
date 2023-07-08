package joao.studies.kafkapocs.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import joao.studies.kafkapocs.producer.config.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import static joao.studies.kafkapocs.producer.config.OutputBinding.KAFKA_NEW_EVENT;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final ObjectMapper mapper;
    private final StreamBridge streamBridge;

    public void sendMessage(KafkaMessage message) {
        try {
            final var messageAsString = mapper.writeValueAsString(message);
            streamBridge.send(KAFKA_NEW_EVENT.getNameEvent(), messageAsString);
        } catch (Exception e) {
            log.error("[KafkaProducer] :: error to produce message :: {} ", e.getMessage());
        }

    }


}
