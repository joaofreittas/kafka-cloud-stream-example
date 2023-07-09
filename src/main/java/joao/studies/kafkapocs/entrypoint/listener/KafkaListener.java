package joao.studies.kafkapocs.entrypoint.listener;

import joao.studies.kafkapocs.entrypoint.listener.config.MessageBody;
import joao.studies.kafkapocs.infrastructure.messaging.kafka.payloads.NewEventPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaListener {

    @Bean
    public Consumer<MessageBody> kafkaNewEvent() {
        return this::process;
    }

    private void process(MessageBody messageBody) {
        final var event = (NewEventPayload) messageBody.getPayload();

        log.info("[KafkaListener] :: new event received :: message={}", event.getMessage());
    }

}
