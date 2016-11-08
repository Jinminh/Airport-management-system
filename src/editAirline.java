package air;

import java.sql.*;
import java.util.Vector;

public class editAirline {

	public static void main(String args[]) {
		new editAirline();
	}

	public Vector Search(){
		Vector vc=new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql = "SELECT * FROM AIRLINES";
			ResultSet rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				Resulta rst=new Resulta();
				rst.name=rs.getString(1);
				rst.website=rs.getString(3);
				rst.code=rs.getString(2);
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

	public boolean edit() {
		
		Vector vc=new Vector();
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql;
			int rs = 0;
			for(int i=0;i<edit_AirLine.model.getRowCount();i++){
				System.out.println(edit_AirLine.model.getValueAt(i, 0)+" "+edit_AirLine.model.getValueAt(i, 1)+" "+edit_AirLine.model.getValueAt(i, 2));
				strSql = "UPDATE AIRLINES SET NAME='"+edit_AirLine.model.getValueAt(i, 0)+"',CODE='"+edit_AirLine.model.getValueAt(i, 1)+"',WEBSITE='"+
			edit_AirLine.model.getValueAt(i, 2)+"' WHERE CODE="+edit_AirLine.model.getValueAt(i, 1);
				 rs= stmt.executeUpdate(strSql);
				 if(rs<=0){
					 return false;
				 }
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}

	public boolean delete() {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			System.out.println(edit_AirLine.model.getValueAt(edit_AirLine.jta.getSelectedRow(),1));
			String strSql="DELETE FROM AIRLINES WHERE CODE='"+edit_AirLine.model.getValueAt(edit_AirLine.jta.getSelectedRow(),1)+"'";
			stmt.executeUpdate(strSql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean add(String s1,String s2,String s3) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521:mg";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conn = DriverManager.getConnection(url, "scott",
					"chh2014zx");
			Statement stmt = conn.createStatement();
			String strSql="INSERT INTO AIRLINES VALUES('"+s1+"','"+s2+"','"+s3+"')";
			stmt.executeUpdate(strSql);
			stmt.close();
			conn.close();
		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
		
		return true;
	}
}

class Resulta{
	String code;
	String website;
	String name;
}


