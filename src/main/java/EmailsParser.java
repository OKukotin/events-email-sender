import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmailsParser {
    private File dataFile;
    private FileReader reader;

    EmailsParser() throws FileNotFoundException {
        this.dataFile = new File("./src/main/resources/listOfInvitees.csv");
        this.reader = new FileReader(this.dataFile);
    }

    public List<String[]> getEmails() throws Exception {
        CSVReader csvReader = new CSVReader(this.reader);
        List<String[]> list = csvReader.readAll();
        this.reader.close();
        csvReader.close();
        return list;
    }
}
