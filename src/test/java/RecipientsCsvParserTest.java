import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class RecipientsCsvParserTest {

    @Test
    void whenRecipientsIsPresentInTheFile_presentInTheList() {
        List<Recipient> expectedRecipients = new ArrayList<>();
        expectedRecipients.add(new Recipient("Saske Pawlyuk", " saske.pawlyuk2012@gmail.com"));
        expectedRecipients.add(new Recipient("Loki Laufeyson", " loki.laufeyson@gmail.com"));

        final RecipientsCsvParser csvParser = new RecipientsCsvParser();
        final List<Recipient> actualRecipients = csvParser.getRecipients();

        Assertions.assertEquals(expectedRecipients, actualRecipients);
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