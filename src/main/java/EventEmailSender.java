public class EventEmailSender {
    public static void main(String[] args) {
        MailtrapConnection connect = new MailtrapConnection();
        connect.getSession();
    }
}
