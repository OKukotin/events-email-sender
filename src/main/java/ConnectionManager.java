import java.util.Properties;

public class ConnectionManager {
    private Properties properties;

    ConnectionManager() {
        this.properties = new Properties();
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls", "true");
        this.properties.put("mail.smtp.host", "smtp.mailtrap.io");
        this.properties.put("mail.smtp.port", "2525");
        this.properties.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
    }

    public Properties getProperties() {
        return properties;
    }
}
