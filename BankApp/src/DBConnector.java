
/* Copyright  http://morshalim.webs.com/ � All Rights Reserved. Modification of
			    this code is Strictly prohibited. */
import java.sql.*;


public class DBConnector 
{

	Connection con;
	Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","msk",/*user name*/"msk"/*password*/);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
