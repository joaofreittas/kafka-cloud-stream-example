package joao.studies.kafkapocs.core.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "spring.mail")
public class EmailConfigProperties {

    private String username;

}
