package vitiger.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains all the generic methods related to database 
 * @author Admin
 *
 */
public class DataBaseUtility {
 /**
  * this method will establish connection with data base
  */
	Driver driverRef;
	Connection con=null;
	public void connectToDB() throws SQLException
	{
		driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(ConstantsUtility.DBUrl, ConstantsUtility.DBUsername,ConstantsUtility.DBPassword);
	}
	/**
	 * this method will close the connection with DB
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException
	{
		con.close();
	}
	/**
	 * this method will execute the query and check for the expected data
	 * if data expected found,it will return the data
	 * else return null data
	 * data validation with respect database
	 * @param query
	 * @param colindex
	 * @param expData
	 * @return
	 * @throws SQLException
	 */
	
	public String executeQueryAndGetTheData(String query,int colindex,String expData) throws SQLException
	{
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			String actulData = result.getString(colindex);
			if(actulData.equals(expData));
			{
				flag=true;  //flag rising
				break;
			}
		}
		if(flag)
		{
			System.out.println("data present"+expData);
			return expData;
		}
		else
		{
			System.out.println("data is not present");
			return " ";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
