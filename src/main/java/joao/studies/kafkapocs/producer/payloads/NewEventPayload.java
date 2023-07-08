package joao.studies.kafkapocs.producer.payloads;

import joao.studies.kafkapocs.producer.config.EventSource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewEventPayload implements EventSource {

    private String message;

    @Override
    public String getEvent() {
        return "NEW_EVENT";
    }

}
