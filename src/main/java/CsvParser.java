import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    private List fileRows = new ArrayList();

    public CsvParser(String infile) throws IOException, CsvValidationException{

        if(checkFile(infile)){
            readCsv(infile);
        }
    }

    protected void readCsv(String csvinfile) throws IOException, CsvValidationException{

        FileInputStream csvStream = new FileInputStream(csvinfile);
        InputStreamReader inputStream = new InputStreamReader(csvStream, StandardCharsets.UTF_8);
        CSVReader reader = new CSVReader(inputStream);


        String[] nextLine;
        while ((nextLine = reader.readNext()) != null){
            fileRows.add(nextLine);
        }
        reader.close();
    }

    protected void writeCsv(String csvoutfile){
        // not used yet
    }

    protected void printCsv(){
        for(Object row : fileRows){
            for(String fields : (String[]) row){
                System.out.println(fields + ",");
            }
            System.out.println("\b\b\n---------------------");
        }
    }

    private boolean checkFile(String csvFile){
        if(!Files.exists(Paths.get(csvFile))){
            System.out.println("File doesn't exist");
            return false;
        }
        return true;
    }
}
