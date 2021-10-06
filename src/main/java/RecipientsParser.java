import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RecipientsParser {
    private File dataFile;
    private FileReader reader;

    RecipientsParser() throws FileNotFoundException {
        this.dataFile = new File("./src/main/resources/listOfInvitees.csv");
        this.reader = new FileReader(this.dataFile);
    }

    public List<Recipient> getRecipients() throws IOException, CsvException {
        List<Recipient> recipients = new ArrayList<>();
        CSVReader csvReader = new CSVReader(this.reader);
        List<String[]> listOfRecords = csvReader.readAll();
        for (String[] record : listOfRecords) {
            recipients.add(new Recipient(record[0], record[1]));
        }
        this.reader.close();
        csvReader.close();

        return recipients;
    }
}
