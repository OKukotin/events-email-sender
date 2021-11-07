import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RecipientsCsvParserTest {

    @Test
    void whenRecipientsIsPresentInTheFile_presentInTheList() {
        final RecipientsCsvParser csvParser = new RecipientsCsvParser();

        final List<Recipient> recipients = csvParser.getRecipients();

        // TODO: add test file Recipients.csv into test/resources. Check specific recipients instead checking on empty
        Assertions.assertFalse(recipients.isEmpty());
    }

    @Test
    void whenRecipientsIsNoPresentInTheFile_absentInTheList() {
        // TODO: implement
    }

    @Test
    void whenTheTitleIsPresentInTheFile_skipTitle() {
        // TODO: implement
    }
}