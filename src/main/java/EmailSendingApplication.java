import java.util.List;

public class EmailSendingApplication {

    public static void main(String[] args) {
        final MailTrapMessageSender mailTrapMessageSender = new MailTrapMessageSender();
        final RecipientsCsvParser parser = new RecipientsCsvParser();
        final EventMessageFactory messageFactory = new EventMessageFactory(new MailTrapSessionSource().getSession());
        final List<Recipient> recipients = parser.getRecipients();
        for (Recipient recipient : recipients) {
            mailTrapMessageSender.send(messageFactory.getIndividualMessage(recipient));
        }
    }
}
