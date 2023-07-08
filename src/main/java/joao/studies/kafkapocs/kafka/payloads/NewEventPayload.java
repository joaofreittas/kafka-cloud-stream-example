package joao.studies.kafkapocs.kafka.payloads;

import joao.studies.kafkapocs.kafka.producer.config.EventSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewEventPayload implements EventSource {

    public static final String EVENT = "NEW_EVENT";

    private String message;

    @Override
    public String getEvent() {
        return EVENT;
    }

}
