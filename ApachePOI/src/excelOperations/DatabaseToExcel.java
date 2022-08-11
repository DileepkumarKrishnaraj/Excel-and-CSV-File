package excelOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//1. Establish the connection with the Database
//2. Get the data from the table 
//3. Write the same data in the MS-Excel

public class DatabaseToExcel {

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENT_DETAILS");
		
		//Excel
		XSSFWorkbook workbook = new XSSFWorkbook();
		workbook.createSheet("Student Details");
		
		XSSFRow row = sheet.crea

	}

}
