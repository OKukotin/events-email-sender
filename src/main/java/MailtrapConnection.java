import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class MailtrapConnection {
    final private Properties properties;
    protected Authenticator loginData;

    MailtrapConnection() {
        this.properties = new Properties();
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls", "true");
        this.properties.put("mail.smtp.host", "smtp.mailtrap.io");
        this.properties.put("mail.smtp.port", "2525");
        this.properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        this.loginData = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("4982a8dd228cd2", "58eeced780cd4c");
            }
        };
    }

    public Session getSession() {
        return Session.getInstance(this.properties, this.loginData);
    }
}
