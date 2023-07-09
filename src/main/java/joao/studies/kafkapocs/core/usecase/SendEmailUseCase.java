package joao.studies.kafkapocs.core.usecase;

import joao.studies.kafkapocs.core.utils.EmailConfigProperties;
import joao.studies.kafkapocs.entrypoint.listener.payloads.NewNotificationPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendEmailUseCase {

    private final JavaMailSender javaMailSender;
    private final EmailConfigProperties emailConfigProperties;

    public void execute(NewNotificationPayload newNotificationPayload) {

        var mailMessage = new SimpleMailMessage();

        mailMessage.setText(newNotificationPayload.getMessage());
        mailMessage.setTo(newNotificationPayload.getTo());
        mailMessage.setSubject(newNotificationPayload.getSubject());
        mailMessage.setFrom(emailConfigProperties.getUsername());

        javaMailSender.send(mailMessage);

    }

}
