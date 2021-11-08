import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipient recipient = (Recipient) o;
        return Objects.equals(fullName, recipient.fullName) && Objects.equals(email, recipient.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, email);
    }
}
