public class Recipient {

    private final String fullName;
    private final String email;

    Recipient(String name, String email) {
        this.fullName = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }
}
