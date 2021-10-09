import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RecipientsCsvParser {

    private final String fileName;

    RecipientsCsvParser(String fileName) {
        this.fileName = fileName;
    }

    public List<Recipient> getRecipients() {
        List<Recipient> recipients = new ArrayList<>();
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            final Reader reader = new FileReader(classLoader.getResource(this.fileName).getFile());
            final CSVReader csvReader = new CSVReader(reader);
            List<String[]> tempList = csvReader.readAll();
            for (String[] line : tempList) {
                recipients.add(new Recipient(line[0], line[1]));
            }
        } catch (CsvException | IOException e) {
            e.printStackTrace();
        }
        return recipients;
    }
}
