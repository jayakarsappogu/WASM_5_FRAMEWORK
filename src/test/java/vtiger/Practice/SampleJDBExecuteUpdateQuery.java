package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBExecuteUpdateQuery {

	public static void main(String[] args) throws SQLException {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
	
		Statement state = con.createStatement();
		
		String query = "insert into customerinfo values(5,'Rokey',108,'adoni')";
		int result=state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("the data is inserted");
		}
		else
		{
			System.out.println("data is not inserted");
		}
		con.close();
		
	}

}
