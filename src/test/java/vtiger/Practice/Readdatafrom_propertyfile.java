package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readdatafrom_propertyfile {

	public static void main(String[] args) throws IOException {
		//load the file location into fileinputStream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//create object of properties
		Properties pobj=new Properties();
		//load the data into properties
		pobj.load(fis);
		//use the key and read the value
		
		String Browser=pobj.getProperty("browser");
		System.out.println(Browser);
		
		String URL=pobj.getProperty("url");
		System.out.println(URL);

		String USER=pobj.getProperty("username");
		System.out.println(USER);
		
		String PW=pobj.getProperty("password");
		System.out.println(PW);



	}

}
