import javax.mail.Session;
import java.util.List;

public class EmailSendingApplication {

    public static void main(String[] args) {
        final MailTrapMessageSender mailTrapMessageSender = new MailTrapMessageSender();
        final RecipientsCsvParser parser = new RecipientsCsvParser();
        final EventMessageFactory messageFactory = new EventMessageFactory();
        final List<Recipient> recipients = parser.getRecipients();
        final Session session = new MailTrapSessionSource().getSession();
        for (Recipient recipient : recipients) {
            mailTrapMessageSender.send(messageFactory.create(session, recipient));
        }
    }
}
