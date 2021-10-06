import javax.mail.Address;
import javax.mail.internet.InternetAddress;

public class Recipient {
    public String fullName;
    public String email;

    Recipient(String name, String email) {
        this.fullName = name;
        this.email = email;
    }
}
