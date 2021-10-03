import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.*;

public class MessageGenerator {
    public Message msg;
    public MimeBodyPart body;
    public Multipart multipart;

    MessageGenerator(Session session) throws MessagingException {
        this.msg = new MimeMessage(session);
        this.msg.setFrom(new InternetAddress("tobi.laufeyson@gmail.com"));
        this.msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
        this.msg.setSubject("Mail Subject");

        this.body = new MimeBodyPart();
        this.body.setContent(this.msg, "text/html");

        this.multipart = new MimeMultipart();
        this.multipart.addBodyPart(this.body);

        this.msg.setContent(this.multipart);
    }
}
