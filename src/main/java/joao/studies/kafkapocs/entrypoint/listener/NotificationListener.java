package joao.studies.kafkapocs.entrypoint.listener;

import joao.studies.kafkapocs.core.usecase.SendEmailUseCase;
import joao.studies.kafkapocs.entrypoint.listener.config.MessageBody;
import joao.studies.kafkapocs.entrypoint.listener.payloads.NewNotificationPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final SendEmailUseCase notificationUseCase;

    @Bean
    public Consumer<MessageBody> newNotification() {
        return this::processMessage;
    }

    private void processMessage(final MessageBody message) {
        notificationUseCase.execute((NewNotificationPayload) message.getPayload());
    }

}
