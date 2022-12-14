package excelOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	public static void main(String args[]) throws IOException {
		String excelFilePath = ".//DataFile//file_example_XLSX_10.xlsx";
		FileInputStream inputstream = new FileInputStream(excelFilePath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
							//FOR LOOP//
		
		/*
		 * int rows = sheet.getLastRowNum(); int columns =
		 * sheet.getRow(1).getLastCellNum();
		 * 
		 * for(int r = 0; r <= rows; r++) { XSSFRow row = sheet.getRow(r);
		 * 
		 * for(int c = 0; c < columns; c++) { XSSFCell cell = row.getCell(c);
		 * 
		 * switch(cell.getCellType()) { case STRING:
		 * System.out.println(cell.getStringCellValue()); break; case NUMERIC:
		 * System.out.println(cell.getNumericCellValue()); break; case BOOLEAN:
		 * System.out.println(cell.getBooleanCellValue()); break; default: break; }
		 * 
		 * System.out.println(" | "); }
		 * 
		 * System.out.println(); }
		 */
		
							//ITERATOR//
		Iterator iterator = sheet.iterator();
		while(iterator.hasNext()) {
			XSSFRow row = (XSSFRow) iterator.next();
			Iterator cellIterator = row.cellIterator();
			while(cellIterator.hasNext()) {
				XSSFCell cell = (XSSFCell) cellIterator.next();
				
				switch(cell.getCellType()) { 
				case STRING:
					 System.out.println(cell.getStringCellValue()); 
					 break; 
				case NUMERIC:
					 System.out.println(cell.getNumericCellValue()); 
					 break; 
				case BOOLEAN:
					 System.out.println(cell.getBooleanCellValue()); 
					 break;
				default: 
					break; 
				}
				System.out.print(" | ");
			}
			System.out.println();
		}
	}
	
}
