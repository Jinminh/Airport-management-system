package air;

import java.sql.*;
import java.util.Vector;

public class Searchpassenger {

	public static void main(String args[]) {
		new Searchpassenger();
	}

	public Vector Search(String str){
		Vector vc=new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql = "SELECT * FROM BAGGAGE WHERE OWNERID='"+str+"'";
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				Resultp rst=new Resultp();
				rst.ID=rs.getString(1);
				rst.flightID=rs.getString(2);
				rst.weight=rs.getString(4);
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

class Resultp{
	
	String ID;
	String flightID;
	String weight;
}

