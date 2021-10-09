import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class MailtrapMessageSender {

    public static void sendMessage(Message message){
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
