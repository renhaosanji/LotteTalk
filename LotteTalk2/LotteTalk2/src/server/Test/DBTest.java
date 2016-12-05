package server.Test;

import java.net.ConnectException;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/chatdb";
		String pass="asdf8812";
		String name="root";
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url,name,pass);
			System.out.println(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.SQL_Query
		//1.INSERT Ctrl+shift+c
//		String sqlString=" Insert into contacts "+
//						" (uid,uname,age,pass,email) "+
//				" value(1008,'Nima',21,'1234','123@w.com')";
//		System.out.println(sqlString);
//		
//		try {
//			PreparedStatement stmt=conn.prepareStatement(sqlString);//������tyr���ʼ��
//			stmt.execute();
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		String sqlString="select uid,uname,email,age,online from contacts";
		System.out.println(sqlString);
		
		try {
			PreparedStatement stmt=conn.prepareStatement(sqlString);
			stmt.executeQuery(sqlString);
			ResultSet rs=stmt.executeQuery(sqlString);
		    System.out.println(rs);
		    
		    //5.Process result set
		    while(rs.next()){
		    	System.out.print("\tuid:\t" + rs.getInt(1) + "       ");
				System.out.print("\tuname:\t\t" + rs.getString(2) + "    ");
				System.out.print("\temail:\t" + rs.getString(3) + "    ");
				System.out.print("\t\tage:\t" + rs.getString(4) + "    ");
				System.out.println("\tOnlien:\t" + rs.getString(5) + "    ");
		    	
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
