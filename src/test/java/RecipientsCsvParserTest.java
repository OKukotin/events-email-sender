import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipientsCsvParserTest {

    @Test
    void getRecipientsReturnNotEmptyList() {
        RecipientsCsvParser csvParser = new RecipientsCsvParser();
        List<Recipient> recipients = csvParser.getRecipients();
        Assertions.assertFalse(recipients.isEmpty());
    }
}