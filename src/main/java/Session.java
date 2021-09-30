import java.net.PasswordAuthentication;
import java.util.Properties;

public class Session {
    private Properties props;
    protected PasswordAuthentication loginData;
    Session(){
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");
        props.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        loginData = new PasswordAuthentication("4982a8dd228cd2","58eeced780cd4c");
    }
    Session(Properties prop){
        props = prop;
    }
}
