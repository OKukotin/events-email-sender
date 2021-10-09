public class EmailSendingApplication {

    public static void main(String[] args) {
        final MailtrapSessionSource sessionSource = new MailtrapSessionSource();
        final RecipientsCsvParser parser = new RecipientsCsvParser("Recipients.csv");
        EventMessageFactory messageFactory = new EventMessageFactory(sessionSource.getSession());
        for (Recipient recipient : parser.getRecipients()) {
            MailtrapMessageSender.sendMessage(messageFactory.getIndividualMessage(recipient));
        }
    }
}
