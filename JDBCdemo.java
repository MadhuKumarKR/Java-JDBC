import java.sql.*;

public class JDBCdemo {
	
	public static void main(String[] args) throws Exception {
	
		String URL = "jdbc:mysql://localhost:{--localhost port number--}/{--Database name--}";
		String UN = "root";
		String PWD = "";
		
//		String query1 = "select * from students";
		String query2 = "select name from students where `Roll No`= 1";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection(URL,UN,PWD);
		System.out.println("Data Base connection established\n");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query2);
		
		//To display all the values of a table using query 1
//		while(rs.next()) {
//			System.out.println(rs.getInt(1)+" "+rs.getString(2));
//		}
		
		//To display individual value using query 2
		rs.next();
		String str = rs.getString("Name");
		System.out.println(str);
		
		st.close();
		conn.close();
	}
}
