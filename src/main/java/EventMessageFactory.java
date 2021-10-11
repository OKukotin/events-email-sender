import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class EventMessageFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventMessageFactory.class);
    private static final String SENDER_EMAIL = "tobi.laufeyson@gmail.com";
    private static final String SUBJECT_OF_EMAIL = "Invitation to event";
    private static final String ATTACHMENT_FILE_NAME = "cat.png";
    private final File attachment;

    EventMessageFactory() {
        this.attachment = loadAttachment();
    }

    Message create(Session session, Recipient recipient) {
        try {
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL));
            message.setSubject(SUBJECT_OF_EMAIL);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.getEmail()));

            final MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(setMessageText(recipient.getFullName()));
            multipart.addBodyPart(attachFile());
            message.setContent(multipart);
            return message;
        } catch (MessagingException | IOException e) {
            LOGGER.error("Cannot create a message", e);
            throw new CreateMessageFailException("Message creating was failed", e);
        }
    }

    private File loadAttachment() {
        final URL resource = getClass().getClassLoader().getResource(ATTACHMENT_FILE_NAME);
        if (resource == null) {
            LOGGER.error("File {} not found", ATTACHMENT_FILE_NAME);
            throw new FileNotExistsException("File not found or empty!");
        }
        return new File(resource.getFile());
    }

    private MimeBodyPart setMessageText(String recipientFullName) throws MessagingException {
        final MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setContent(buildMessageText(recipientFullName), "text/html");
        return textBodyPart;
    }

    private String buildMessageText(String recipientFullName) {
        return "Hello, "
            + recipientFullName
            + ", I invite you to visit my event, which will take place in 3 days!";
    }

    private MimeBodyPart attachFile() throws IOException, MessagingException {
        final MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(attachment);
        return attachmentBodyPart;
    }

    private static final class FileNotExistsException extends RuntimeException {

        public FileNotExistsException(String message) {
            super(message);
        }
    }

    private static final class CreateMessageFailException extends RuntimeException {

        public CreateMessageFailException(String message, Exception exception) {
            super(message, exception);
        }
    }
}