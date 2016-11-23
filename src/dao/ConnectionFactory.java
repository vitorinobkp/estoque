package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory instance = new ConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost:3306/estoque?useLegacyDatatimeCode=false&serverTimezone=UTC&useSSL=false";
	public static final String USER = "root";
	public static final String PASSWORD = "root";
	public static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	
	ConnectionFactory() {
		try {
			Class.forName(DRIVER_CLASS);
		} catch(ClassNotFoundException ex) {
			ex.getMessage();
		}
	}
	
	private Connection createConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch(SQLException ex) {
			ex.getMessage();
		}
		
		return con;
	}
	
	public static Connection getConnection() {
		return instance.createConnection();
	}
}
