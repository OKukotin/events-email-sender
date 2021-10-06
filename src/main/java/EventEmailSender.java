import javax.mail.Session;
import javax.mail.Transport;
import java.util.List;

public class EventEmailSender {
    public static void main(String[] args) throws Exception {
        MailtrapConnection connection = new MailtrapConnection();
        Session sessionInstance = connection.getSession();
        RecipientsParser parser = new RecipientsParser();
        List<Recipient> recipients = parser.getRecipients();
        MessageManager messageManager = new MessageManager(sessionInstance, "Hello, I invite you to visit my event, which will take place in 3 days!");
        messageManager.setRecipients(recipients);

        Transport.send(messageManager.getMessage());
    }
}
