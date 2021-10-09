import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

public class MailtrapMessageSender {

    private Message message;

    MailtrapMessageSender(Message message){
        this.message = message;
    }

    public void sendMessage(){
        try {
            Transport.send(this.message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
