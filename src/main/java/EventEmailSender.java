import javax.mail.MessagingException;
import javax.mail.Session;
import java.util.List;

public class EventEmailSender {
    public static void main(String[] args) throws Exception {
        MailtrapConnection connection = new MailtrapConnection();
        Session sessionInstance = connection.getSession();
        EmailsParser parser = new EmailsParser();
        List<String[]> emails = parser.getEmails();
        for (String[] email : emails) {
            System.out.println(email[1]);
        }
    }
}
