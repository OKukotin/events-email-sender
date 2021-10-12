import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class GmailSessionSource {

    private final Properties properties;
    private final Authenticator authenticator;

    GmailSessionSource(){
        this.properties = new Properties();
        this.properties.put("mail.smtp.auth", SmtpServerProperties.GMAIL.getAuthorization());
        this.properties.put("mail.smtp.starttls", SmtpServerProperties.GMAIL.getStartTls());
        this.properties.put("mail.smtp.host", SmtpServerProperties.GMAIL.getHost());
        this.properties.put("mail.smtp.port", SmtpServerProperties.GMAIL.getPort());
        this.properties.put("mail.smtp.ssl.trust", SmtpServerProperties.GMAIL.getSslTrust());
        this.properties.put("mail.smtp.starttls.enable", SmtpServerProperties.GMAIL.getEnableStartTls());
        this.properties.put("mail.smtp.EnableSSL.enable", SmtpServerProperties.GMAIL.getEnableSsl());
        this.authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SmtpServerProperties.GMAIL.getLogin(), SmtpServerProperties.GMAIL.getPassword());
            }
        };
    }

    public Session getSession() {
        return Session.getInstance(this.properties, this.authenticator);
    }
}
