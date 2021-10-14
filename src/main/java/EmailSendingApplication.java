import javax.mail.Session;
import java.util.List;

public class EmailSendingApplication {

    public static void main(String[] args) {
        final MessageSender messageSender = new MessageSender();
        final RecipientsCsvParser parser = new RecipientsCsvParser();
        final EventMessageFactory messageFactory = new EventMessageFactory();
        final List<Recipient> recipients = parser.getRecipients();
        final Session session = new SmtpSessionSource(SmtpServerProperties.MAILTRAP).getSession();
        for (Recipient recipient : recipients) {
            messageSender.send(messageFactory.create(session, recipient));
        }
    }
}
