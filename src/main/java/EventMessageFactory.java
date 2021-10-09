import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;

public class EventMessageFactory {

    private final Message message;

    EventMessageFactory(Session session) {
        this.message = new MimeMessage(session);
        MimeMultipart multipart = new MimeMultipart();

        try {
            this.message.setFrom(new InternetAddress("tobi.laufeyson@gmail.com"));
            this.message.setSubject("Invitation to event");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public Message getIndividualMessage(Recipient recipient) {
        Message individualMessage = new MimeMessage(this.message.getSession());
        try {
            individualMessage.setFrom(this.message.getFrom()[0]);
            individualMessage.setSubject(this.message.getSubject());
            individualMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient.getEmail()));
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        MimeMultipart multipart = new MimeMultipart();
        String messageText = "Hello, " + recipient.getFullName() +
                ", I invite you to visit my event, which will take place in 3 days!";
        MimeBodyPart attachment = new MimeBodyPart();
        ClassLoader classLoader = this.getClass().getClassLoader();
        File attach = null;
        try {
            attach = new File(classLoader.getResource("cat.png").getFile());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        try {
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(messageText, "text/html");
            attachment.attachFile(attach);
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachment);
            individualMessage.setContent(multipart);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return individualMessage;
    }
}