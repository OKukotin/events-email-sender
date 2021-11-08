import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

class RecipientsCsvParserTest {

    @Test
    void whenRecipientsIsPresentInTheFile_presentInTheList() {
        final List<Recipient> expectedRecipients = new ArrayList<>();
        expectedRecipients.add(new Recipient("Saske Pawlyuk", " saske.pawlyuk2012@gmail.com"));
        expectedRecipients.add(new Recipient("Loki Laufeyson", " loki.laufeyson@gmail.com"));

        final RecipientsCsvParser csvParser = new RecipientsCsvParser();
        final List<Recipient> actualRecipients = csvParser.getRecipients();

        Assertions.assertEquals(expectedRecipients, actualRecipients);
    }

    @Test
    void whenRecipientsIsNoPresentInTheFile_absentInTheList() {
        final List<Recipient> expected = new ArrayList<>();
        expected.add(new Recipient("Foo Bar", "foo.bar@gmail.com"));
        expected.add(new Recipient("Simple User", "simple.user@gmail.com"));

        final RecipientsCsvParser csvParser = new RecipientsCsvParser();
        final List<Recipient> actual = csvParser.getRecipients();

        Assertions.assertFalse(actual.containsAll(expected));
    }

    @Test
    void whenTheTitleIsPresentInTheFile_skipTitle() {
        // TODO: implement
    }
}