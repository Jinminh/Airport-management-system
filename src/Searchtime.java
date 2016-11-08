package air;

import java.sql.*;
import java.util.Vector;

public class Searchtime {

	public static void main(String args[]) {
		new Searchtime();
	}

	public Vector Search(){
		Vector vc=new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql = "SELECT * FROM DEPARTURES";
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				Resultt rst=new Resultt();
				rst.ID=rs.getString(1);
				rst.gate=rs.getString(2);
				rst.date=rs.getString(3);
				rst.status=rs.getString(4);
				vc.add(rst);
			}
			rs.close();
			strSql = "SELECT * FROM ARRIVALS";
			rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				Resultt rst=new Resultt();
				rst.ID=rs.getString(1);
				rst.gate=rs.getString(2);
				rst.date=rs.getString(3);
				rst.status=rs.getString(4);
				vc.add(rst);
			}
			stmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vc;
	}
}

class Resultt{
	
	String ID;
	String gate;
	String date;
	String status;
}

