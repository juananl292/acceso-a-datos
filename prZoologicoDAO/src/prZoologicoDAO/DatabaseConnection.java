package prZoologicoDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	Connection connection;
	
	public Connection getConnection () {
		String dbName= "bd_zoologico";
		String userName= "root";
		String password= "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection= DriverManager.getConnection(""
					+ "jdbc:mysql://localhost/"+ dbName, userName,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
}
