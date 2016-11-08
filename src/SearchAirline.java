package air;

import java.sql.*;
import java.util.Vector;

public class SearchAirline {

	public static void main(String args[]) {
		new SearchAirline();
	}

	public Vector Search(String str){
		Vector vc=new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql = "SELECT * FROM FLIGHTS WHERE AIRLINECODE='"+str+"'";
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				Result rst=new Result();
				rst.flightnumber=rs.getString(2);
				rst.source=rs.getString(3);
				rst.des=rs.getString(4);
				rst.plane=rs.getString(5);
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

class Result{
	
	String flightnumber;
	String source;
	String des;
	String plane;
}

