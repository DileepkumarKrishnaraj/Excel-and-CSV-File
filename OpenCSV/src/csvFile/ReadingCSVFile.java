package csvFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadingCSVFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, CsvException {
		/*
		 * try {
		 * 
		 * // Create an object of filereader // class with CSV file as a parameter.
		 * FileReader filereader = new FileReader(".//DataFile//Sample.csv");
		 * 
		 * // create csvReader object passing // file reader as a parameter CSVReader
		 * csvReader = new CSVReader(filereader); String[] nextRecord;
		 * 
		 * // we are going to read data line by line while ((nextRecord =
		 * csvReader.readNext()) != null) { for (String cell : nextRecord) {
		 * System.out.print(cell + "\t"); } System.out.println(); } } catch (Exception
		 * e) { e.printStackTrace(); }
		 */
		
							//Another Method//
		
		
        try (CSVReader reader = new CSVReader(new FileReader(".//DataFile//Sample.csv"))) {
            List<String[]> r = reader.readAll();
            
            r.forEach(x-> System.out.println(Arrays.toString(x)));
        }
        
	}

}
