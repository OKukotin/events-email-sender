import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RecipientsCsvParserTest {

    @Test
    void whenRecipientsIsPresentInTheFile_NotEmptyList() {
        final RecipientsCsvParser csvParser = new RecipientsCsvParser();

        final List<Recipient> recipients = csvParser.getRecipients();

        // TODO: add test file Recipients.csv into test/resources. Check specific recipients instead checking on empty. And rename method accordingly to changes
        Assertions.assertFalse(recipients.isEmpty());
    }
}