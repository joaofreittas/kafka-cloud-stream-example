package joao.studies.kafkapocs.entrypoint.listener.payloads;

import joao.studies.kafkapocs.infrastructure.messaging.kafka.producer.config.EventSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewNotificationPayload implements EventSource {

    public final static String EVENT = "NEW_NOTIFICATION";

    private String name;
    private String to;
    private String message;
    private String subject;

    @Override
    public String getEvent() {
        return EVENT;
    }

}
