package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import vitiger.GenericUtility.ExcelFileUtility;

public class exampleTest {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InvalidFormatException {
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		eutil.readMultipleDataFromExcel("MultipleOrg");
	}

}
