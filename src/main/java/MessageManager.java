import javax.mail.*;
import javax.mail.internet.*;
import java.util.List;

public class MessageManager {
    private Message msg;
    public MimeBodyPart body;
    public Multipart multipart;

    MessageManager(Session session, String text) throws MessagingException {
        this.msg = new MimeMessage(session);
        this.msg.setFrom(new InternetAddress("tobi.laufeyson@gmail.com"));
        this.msg.setSubject("Invitation to event");

        this.body = new MimeBodyPart();
        this.body.setContent(text, "text/html");

        this.multipart = new MimeMultipart();
        this.multipart.addBodyPart(this.body);

        this.msg.setContent(this.multipart);
    }

    public void setRecipients(List<Recipient> recipients) throws MessagingException {
        String emailsString = "";
        for (Recipient rec : recipients) {
            emailsString += rec.email + ",";
        }
        this.msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailsString));
    }

    public Message getMessage() {
        return this.msg;
    }
}
