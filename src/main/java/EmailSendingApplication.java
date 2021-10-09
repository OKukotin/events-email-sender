import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.List;

public class EmailSendingApplication {

    public static void sendMessage(Message message) {
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MailtrapSessionSource connection = new MailtrapSessionSource();
        RecipientsCsvParser parser = new RecipientsCsvParser("Recipients.csv");
        List<Recipient> recipients = parser.getRecipients();
        for (Recipient recipient : recipients) {
            EventMessageFactory messageFactory = new EventMessageFactory(connection.getSession(), recipient);
            sendMessage(messageFactory.getMessage());
        }
    }
}
