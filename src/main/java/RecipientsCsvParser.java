import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipientsCsvParser {

    private final Logger LOGGER = LoggerFactory.getLogger(RecipientsCsvParser.class);
    private static final String LIST_OF_RECIPIENTS_CSV = "Recipients.csv";
    private static final int NUMBER_OF_LINES_TO_SKIP = 1;

    public List<Recipient> getRecipients() {
        final List<Recipient> recipients = new ArrayList<>();
        final ClassLoader classLoader = getClass().getClassLoader();

        try {
            final String fileName = Objects.requireNonNull(classLoader.getResource(LIST_OF_RECIPIENTS_CSV)).getFile();
            final CSVReader csvReader = new CSVReader(new FileReader(fileName));
            csvReader.skip(NUMBER_OF_LINES_TO_SKIP);
            for (String[] line : csvReader.readAll()) {
                recipients.add(new Recipient(line[0], line[1]));
            }
        } catch (CsvException | IOException e) {
            LOGGER.error("Cannot parse the next CSV file: {}", LIST_OF_RECIPIENTS_CSV, e);
            throw new CsvFileReadingException("Cannot parse CSV file", e);
        } catch (NullPointerException e) {
            LOGGER.error("Cannot find {} CSV file", LIST_OF_RECIPIENTS_CSV, e);
            throw new CsvFileReadingException("Cannot find CSV file", e);
        }
        return recipients;
    }

    private static final class CsvFileReadingException extends RuntimeException {
        public CsvFileReadingException(String message, Exception exception) {
            super(message, exception);
        }
    }
}
