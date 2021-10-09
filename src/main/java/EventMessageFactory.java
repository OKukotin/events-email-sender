import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;

public class EventMessageFactory {

    private final Message message;

    EventMessageFactory(Session session, Recipient recipient) {
        this.message = new MimeMessage(session);

        MimeBodyPart textPart = new MimeBodyPart();
        MimeBodyPart attachment = new MimeBodyPart();
        MimeMultipart multipart = new MimeMultipart();
        String messageText = "Hello, " + recipient.getFullName() +
                ", I invite you to visit my event, which will take place in 3 days!";
        try {
            this.message.setFrom(new InternetAddress("tobi.laufeyson@gmail.com"));
            this.message.setSubject("Invitation to event");
            this.message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient.getEmail()));
            textPart.setContent(messageText, "text/html");

            ClassLoader classLoader = this.getClass().getClassLoader();
            File attach = new File(classLoader.getResource("cat.png").getFile());
            try {
                attachment.attachFile(attach);
            } catch (IOException e) {
                e.printStackTrace();
            }
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachment);
            this.message.setContent(multipart);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public Message getMessage() {
        return message;
    }
}