import javax.mail.MessagingException;
import javax.mail.Session;

public class EventEmailSender {
    public static void main(String[] args) throws MessagingException {
        MailtrapConnection connection = new MailtrapConnection();
        Session sessionInstance = connection.getSession();
        MessageGenerator msgGen = new MessageGenerator(sessionInstance);

    }
}
