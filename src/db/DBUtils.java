package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
	public static PreparedStatement getPreparedStatement(String sql) {
		System.out.println("Ket noi CSDL ");
	    String hostName = "localhost";
	    String dbName = "Beauty";
	    String userName = "root";
	    String password = "password";
	    PreparedStatement ps = null;

	    
	    Connection conn = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName+"?useUnicode=yes&characterEncoding=UTF-8";
			conn = DriverManager.getConnection(connectionURL, userName,password);
			ps = conn.prepareStatement(sql);
			System.out.println("ket noi thanh cong");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return ps;
	}
	public static void main(String[] args) {
		

	}

}
