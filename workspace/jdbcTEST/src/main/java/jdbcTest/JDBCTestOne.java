package jdbcTest;

import java.sql.*;

public class JDBCTestOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Konnte den SQL Driver nicht laden.");
			System.exit(-1);
		}
		
		
		String url = "jdbc:mysql://localhost:3306/testjdbc";
		try {
			//verbindung zur datenbank herstellen
			Connection con = DriverManager.getConnection(url, "root", "root");
			
			// Statemant erzeugen
			PreparedStatement stmt = con.prepareStatement("select ? from test where name like ?");
			//stmt.setString(1, "name");
			stmt.setString(1, "c%");
			//System.out.println(pstmt.toString());
			ResultSet rSet = stmt.executeQuery();
			
			//Statement stmt = con.createStatement();
			//ResultSet rSet = stmt.executeQuery("select * from test where name is not null");
			
			// alle ergebinsse ausgeben
			while(rSet.next()) {
				//System.out.println(rSet.getString(1) + rSet.getString(2) + rSet.getString(3));
				System.out.println(rSet.getString(1) );
			}
		
			stmt.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Konnte Datenbank \"test\" nicht finden");
		} /*finally {
			if (con != null) {
				try {con.close();}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}*/
		
		
		
		
	}

}
