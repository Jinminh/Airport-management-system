package air;

import java.sql.*;
import java.util.Vector;

public class Searchdepartrue_arrival {

	public static void main(String args[]) {
		new Searchdepartrue_arrival();
	}

	public Vector Search(String str,int type){
		Vector vc=new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql="";
			if(type==1){
				strSql = "SELECT * FROM PASSENGERS WHERE ARRIVALID='"+str+"'";
			}else{
				strSql = "SELECT * FROM PASSENGERS WHERE DEPATURESID='"+str+"'";
			}
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				Resultda rst=new Resultda();
				rst.fname=rs.getString(2);
				rst.lname=rs.getString(3);
				rst.cs=rs.getString(4);
				rst.a=rs.getString(7);
				rst.d=rs.getString(8);
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

class Resultda{
	
	String fname;
	String lname;
	String cs;
	String a;
	String d;
}

