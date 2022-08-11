package excelOperations;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Creating and Writing Data in an Excel Sheet 
//Workbook-->Sheet-->Rows-->Cells
public class WritingExcel {
	
	public static void main(String args[]) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee Information");
		
		Object employeeData[][] = { {"EmpID","EmpName","EmpSalary"},
									{1,"Dileepkumar","10000"},
									{2,"Nitheeshkumar","20000"},
									{3,"Kalaiselvan","30000"},
									{4,"Yamini","40000"}
				
								   };
		
					//NORMAL FORLOOP//
		
		int rows = employeeData.length;
		int columns = employeeData[0].length;
		
		System.out.println(rows);	    //5
		System.out.println(columns);	//3
		
		for(int r = 0; r < rows; r++) {
			XSSFRow row = sheet.createRow(r);
			for(int c = 0; c < columns; c++) {
				XSSFCell cell = row.createCell(c);
				Object value = employeeData[r][c];
				
				if(value instanceof String) {
					cell.setCellValue((String)value);
				}
				if(value instanceof Integer) {
					cell.setCellValue((Integer)value);
				}
				if(value instanceof Boolean) {
					cell.setCellValue((Boolean)value);
				}
				
			}
			
			String filePath = ".//DataFile//Employee.xlsx";
			FileOutputStream outstream = new FileOutputStream(filePath);
			workbook.write(outstream);
			outstream.close();
			
			
		}
		System.out.println("File written successfully");
	}

}
