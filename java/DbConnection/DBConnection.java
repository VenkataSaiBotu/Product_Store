package test;

import java.sql.*;

public class DBConnection 
{
	private static Connection conn = null;

	public DBConnection() {
		super();
	}
	
	static {
		try {
			Class.forName(DBInfo.driver);
			conn = DriverManager.getConnection(DBInfo.url,DBInfo.dbUname,DBInfo.password);
		} catch (Exception e) {
			System.out.println("unable to load connection");
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}
}
