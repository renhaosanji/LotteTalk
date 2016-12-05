package server.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DB 접근할 때

public class DBAccessHelper {
	private static DBAccessHelper dao;
	
	private DBAccessHelper() { // private
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static DBAccessHelper getDAO() {
		if (dao == null)
			dao = new DBAccessHelper();
		return dao;
	}
	private Connection getConnection() {
		Connection conn=null;
		String url = "jdbc:mysql://localhost:3306/chatdb";
		String pass = "asdf8812";
		String name = "root";
		
		try {
			conn = DriverManager.getConnection(url, name, pass);
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
//execute()
	public void execute(String sqlString) {
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlString);// 
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	// excuteQuaryexecute
	public ResultSet executeQuery(String sqlString) {
		ResultSet rs = null;
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sqlString);// tyr
			rs=stmt.executeQuery();        //.execute

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
