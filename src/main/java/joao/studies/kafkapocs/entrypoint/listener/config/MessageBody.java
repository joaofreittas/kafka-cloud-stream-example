package joao.studies.kafkapocs.entrypoint.listener.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import joao.studies.kafkapocs.entrypoint.listener.payloads.NewNotificationPayload;
import joao.studies.kafkapocs.infrastructure.messaging.kafka.producer.config.EventSource;
import joao.studies.kafkapocs.infrastructure.messaging.kafka.payloads.NewEventPayload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageBody {

    private String event;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "event")
    @JsonSubTypes(value = {
        @JsonSubTypes.Type(value = NewEventPayload.class, names = { NewEventPayload.EVENT }),
        @JsonSubTypes.Type(value = NewNotificationPayload.class, names = { NewNotificationPayload.EVENT }),
    })
    private EventSource payload;
}