import java.util.Properties;

public class Session {
    private Properties props;
    Session(){
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
    }
}
