import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EmailsParser {
    private String pathToData;

    EmailsParser() {
        this.pathToData = "../../data/listOfInvitees.csv";
    }

    public List<String[]> getEmails() throws IOException, CsvException {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(this.pathToData));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader.readAll();
    }
}
