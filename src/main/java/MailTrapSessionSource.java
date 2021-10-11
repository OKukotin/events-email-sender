import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class MailTrapSessionSource {

    private final Properties properties;
    private final Authenticator loginData;

    MailTrapSessionSource() {
        this.properties = new Properties();
        this.properties.put("mail.smtp.auth", SmtpServerProperties.MAILTRAP.getAuthorization());
        this.properties.put("mail.smtp.starttls", SmtpServerProperties.MAILTRAP.getStartTls());
        this.properties.put("mail.smtp.host", SmtpServerProperties.MAILTRAP.getHost());
        this.properties.put("mail.smtp.port", SmtpServerProperties.MAILTRAP.getPort());
        this.properties.put("mail.smtp.ssl.trust", SmtpServerProperties.MAILTRAP.getSslTrust());
        this.loginData = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SmtpServerProperties.MAILTRAP.getLogin(), SmtpServerProperties.MAILTRAP.getPassword());
            }
        };
    }

    Session getSession() {
        return Session.getInstance(this.properties, this.loginData);
    }
}
