package air;

import java.sql.*;
import java.util.Vector;

public class Searchplace {


	public Vector Search(String str){
		Vector vc=new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql = "SELECT * FROM FLIGHTS WHERE SOURCE='"+str+"' OR DESTINATION='"+str+"'";
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				Resultpl rst=new Resultpl();
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

class Resultpl{
	
	String flightnumber;
	String source;
	String des;
	String plane;
}

