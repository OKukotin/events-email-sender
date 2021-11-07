import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RecipientsCsvParserTest {

    @Test
    void whenRecipientsIsPresentInTheFile_NotEmptyList() {
        final RecipientsCsvParser csvParser = new RecipientsCsvParser();

        final List<Recipient> recipients = csvParser.getRecipients();

        Assertions.assertFalse(recipients.isEmpty());
    }
}