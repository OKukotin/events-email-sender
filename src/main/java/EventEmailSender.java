import javax.mail.Authenticator;
import javax.mail.Session;

public class EventEmailSender {
    public static void main(String[] args) {

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication("4982a8dd228cd2", "58eeced780cd4c");
            }
        });
    }
}
