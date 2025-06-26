package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	
	private static Connection conn = null;
	
	private static String driver = "com.mysql.cj.jdbc.Driver";	
	private static String url = "jdbc:mysql://localhost:3306/rootdesk_db?useSSL=false&serverTimezone=America/Sao_Paulo&characterEncoding=UTF-8";
    private static String user = "root";
    private static String password = "1234567";
    
    public static Connection getConnection() {
    	if (conn == null) {
    		try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException | ClassNotFoundException e) {
				throw new DbException(e.getMessage());
			}
    	}
    	return conn;
    }
    
    public static void closeConnection() {
    	if (conn != null) {
    		try {
    			conn.close();
    		} catch (SQLException e) {
    			throw new DbException(e.getMessage());
    		}
    	}
    }
    
    public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			}
		}
	}
	
}
