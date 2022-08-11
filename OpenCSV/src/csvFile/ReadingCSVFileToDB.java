package csvFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReadingCSVFileToDB {

	public static void main(String[] args) throws SQLException, IOException {
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		String h2 = "INSERT INTO DETAILS_OF_STUDENT(name,rollno,department,result,cgpa) VALUES(?,?,?,?,?)";

		try { 
		        BufferedReader br = new BufferedReader(new FileReader(".//DataFile//Sample.csv"));
		        String line = ""; 
		        while ((line = br.readLine()) != null) {
		            try {

		                if (line != null) 
		                {
		                    String[] array = line.split(",+");
		                    for(String result:array)
		                    {
		                        System.out.println(result);
		 //Create preparedStatement here and set them and exEcute them
		                PreparedStatement ps = con.prepareStatement(h2);
		                 ps.setString(1,array[0]);
		                 ps.setString(2,array[1]);
		                 ps.setString(3,array[2]);
		                 ps.setString(4,array[3]);
		                 ps.setString(5,array[4]);
		                 ps.executeUpdate();
		                 ps.close();
		   //Assuming that your line from file after split will follow that sequence

		                    }
		                } 
		            }
		            finally
		            {
		               if (br == null) 
		                {
		                    br.close();
		                }
		            }
		        }
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    }

	}

}
