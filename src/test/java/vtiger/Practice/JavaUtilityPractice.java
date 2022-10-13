package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import vitiger.GenericUtility.ExcelFileUtility;
import vitiger.GenericUtility.JavaUtility;
import vitiger.GenericUtility.PropertyFileUtility;

public class JavaUtilityPractice {
	
	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException  {
		
		JavaUtility jLib=new JavaUtility();
		int ra = jLib.getRandomNumber();
		System.out.println(ra);
		String date = jLib.getSystemDate();
		System.out.println(date);
		String d = jLib.getSystemDateInFormat();
		System.out.println(d);
		
		PropertyFileUtility pLib=new PropertyFileUtility();
		String b = pLib.readDataFromPropertyFile("browser");
		System.out.println(b);
		
		ExcelFileUtility eLib=new ExcelFileUtility();
		String data = eLib.readDataFromExcel("Organization", 1, 2);
	    eLib.writeDataIntoExcel("Organization", 1, 6, "Chaitra");
		System.out.println("data added");
	}

}

