package proiect.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;

public class CsvWriter {

    private static CsvWriter INSTANCE;
    private static String CSV_PATH_WRITE = "CsvFile";

    private CsvWriter() {
    }

    public static CsvWriter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CsvWriter();
        }

        return INSTANCE;
    }

    public String writeLines(List<String[]> lines) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(CSV_PATH_WRITE, true))) {  //avem true ca sa se adauge la ce exista deja, nu sa rescrie fisierul
            writer.writeAll(lines);
        }

        return Files.readString(Path.of(CSV_PATH_WRITE));
    }
}
