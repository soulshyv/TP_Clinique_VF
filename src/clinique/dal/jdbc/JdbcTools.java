package clinique.dal.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import clinique.dal.Config;

public class JdbcTools {
	private static  String urldb;
	private static String userdb;
	private static String passworddb;
	
	static {
		
		try {
			Class.forName(Config.getProperty("driverdb"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
		urldb = Config.getProperty("urldb");
		userdb = Config.getProperty("userdb");
		passworddb = Config.getProperty("passworddb");
		System.out.println("urldb="+urldb+";userdb="+userdb+";passworddb="+passworddb);
	}
	
	
	
	public static Connection getConnection() throws SQLException{
		Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
		
		return connection;
	}
}