import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SmtpSessionSource {

    private final Properties properties;
    private final Authenticator authenticator;

    SmtpSessionSource(SmtpServerProperties smtpServerProperties) {
        this.properties = new Properties();
        this.properties.put("mail.smtp.auth", smtpServerProperties.getAuthorization());
        this.properties.put("mail.smtp.starttls", smtpServerProperties.getStartTls());
        this.properties.put("mail.smtp.host", smtpServerProperties.getHost());
        this.properties.put("mail.smtp.port", smtpServerProperties.getPort());
        this.properties.put("mail.smtp.ssl.trust", smtpServerProperties.getSslTrust());
        this.properties.put("mail.smtp.starttls.enable", smtpServerProperties.getEnableStartTls());
        this.properties.put("mail.smtp.EnableSSL.enable", smtpServerProperties.getEnableSsl());
        this.authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpServerProperties.getLogin(), smtpServerProperties.getPassword());
            }
        };
    }

    public Session getSession() {
        return Session.getInstance(this.properties, this.authenticator);
    }
}
