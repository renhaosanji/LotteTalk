package server.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import server.helper.DBAccessHelper;

public class DAOTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String tempString = "YY";
			int uid = 10043;
			String sqlString = " Insert into contacts "
					+ " (uid,uname,age,pass,email,online) "
					+ " values("+uid+",'"+tempString+"',21,'1234','123@wjq.com','1')";
			System.out.println(sqlString);
			DBAccessHelper.getDAO().execute(sqlString);

			sqlString = "select uid,uname,age,email,online from contacts";
			System.out.println(sqlString);

			ResultSet rs = DBAccessHelper.getDAO().executeQuery(sqlString);
			
			while (rs.next()) {
				System.out.print("  uid\t" + rs.getInt(1) + "       ");
				System.out.print("  uname:\t  " + rs.getString(2) + "    ");
				System.out.print("  email:\t" + rs.getString(3) + "    ");
				System.out.print("  age:\t" + rs.getString(4) + "    ");
				System.out.println("  Onlien:\t" + rs.getString(5) + "    ");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
