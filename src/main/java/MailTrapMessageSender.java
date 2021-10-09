import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class MailTrapMessageSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailTrapMessageSender.class);

    public void send(Message message) {
        try {
            Transport.send(message);
            LOGGER.info("Sent message for the next recipient: {}", (Object) getAllRecipients(message));
        } catch (MessagingException e) {
            LOGGER.error("Cannot send message for next recipients: {}", getAllRecipients(message), e);
        }
    }

    private Address[] getAllRecipients(Message message) {
        try {
            return message.getAllRecipients();
        } catch (MessagingException e) {
            LOGGER.error("Cannot get list of recipients", e);
            return new Address[0];
        }
    }
}
