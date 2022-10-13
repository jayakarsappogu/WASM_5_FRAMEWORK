package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readdata_excelsheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		 //Step 1: load the file into input stream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//step 2:  Create workbook using workbook factory
		Workbook wb = WorkbookFactory.create(fis);
	 org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("MultipleOrg");
	int rowcount = sheet.getLastRowNum();
	System.out.println(rowcount);
		//step 3: navigate to sheet
		//Sheet sheet= wb.getSheet("Organization");
		
		//step 4: navigate to row
     	// Row row =sheet.getRow(1);
		

	}

}
