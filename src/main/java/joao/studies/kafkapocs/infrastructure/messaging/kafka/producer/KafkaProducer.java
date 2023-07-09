package joao.studies.kafkapocs.infrastructure.messaging.kafka.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import joao.studies.kafkapocs.infrastructure.messaging.kafka.producer.config.KafkaMessage;
import joao.studies.kafkapocs.infrastructure.messaging.kafka.producer.config.OutputBinding;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final ObjectMapper mapper;
    private final StreamBridge streamBridge;

    public void sendMessage(KafkaMessage message) {
        try {
            final var messageAsString = mapper.writeValueAsString(message);
            streamBridge.send(OutputBinding.KAFKA_NEW_EVENT.getNameEvent(), messageAsString);
        } catch (Exception e) {
            log.error("[KafkaProducer] :: error to produce message :: {} ", e.getMessage());
        }

    }


}
