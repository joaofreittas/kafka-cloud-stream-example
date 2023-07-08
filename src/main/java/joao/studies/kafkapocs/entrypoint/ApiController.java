package joao.studies.kafkapocs.entrypoint;

import joao.studies.kafkapocs.producer.KafkaProducer;
import joao.studies.kafkapocs.producer.config.KafkaMessage;
import joao.studies.kafkapocs.producer.payloads.NewEventPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final KafkaProducer kafkaProducer;

    @PostMapping
    public void send() {
        final var payload = NewEventPayload.builder()
                .message("Joao")
                .build();

        final var kafkaMessage = KafkaMessage.builder()
            .payload(payload)
            .event(payload.getEvent())
            .build();

        kafkaProducer.sendMessage(kafkaMessage);

    }

}
