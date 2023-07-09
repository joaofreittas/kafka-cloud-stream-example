package joao.studies.kafkapocs.core.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Email {

    private String from;
    private String to;
    private String subject;
    private String message;

}
