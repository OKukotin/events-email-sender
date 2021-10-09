import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class MailTrapSessionSource {

    private final Properties properties;
    private final Authenticator loginData;

    MailTrapSessionSource() {
        this.properties = new Properties();
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls", "true");
        this.properties.put("mail.smtp.host", "smtp.mailtrap.io");
        this.properties.put("mail.smtp.port", "2525");
        this.properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        final String username = System.getenv().getOrDefault("LOGIN", "John Doe");
        final String password = System.getenv().getOrDefault("PASSWORD", "Open Sesame");
        this.loginData = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
    }

    Session getSession() {
        return Session.getInstance(this.properties, this.loginData);
    }
}
