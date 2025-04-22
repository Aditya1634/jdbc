package prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetPractice {
	static String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=tiger";
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		String user = "postgres";
//		String password = "tiger";
		
		//we can pass the data inside the url as well.
//		getAllStudents();
		getResSetMethod();
		
		//executeQuery - convert table into java object which is a result set
		
	}
	public static void getAllStudents() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		
		Connection connect = DriverManager.getConnection(url);
		//getConnection is overloaded method
		
		String sql = "Select * from student";
		
		
		
		//String sql = "Insert into student values (25,'random','F','O+ve',984562)";
		//for insert, delete queries it will show exception for executeQuery method as the result set is not created for the query. 
		//but the query will run and the data will be changes inside the table of the database
		
		Statement stmt = connect.createStatement();
		//if taking hardcoded input, use statement
		
		
		ResultSet rs = stmt.executeQuery(sql); 
		//executeQuery is a factory method ISLIYE object ban raha, warna ResultSet is an interface, can't be created object
		
		
		//in set, order of insertion is not maintained
		
		System.out.println(rs);
		
		while(rs.next()) { //next method present inside ResultSet interface and returns true if data is present
			int id = rs.getInt(1); //rs.getInt("id")
			String name = rs.getString(2); //rs.getString("name")
			String gender = rs.getString(3); //rs.getString("gender")
			
			System.out.println(id + " " + name + " " + gender);
		}
		
	}
	
	public static void getResSetMethod() throws ClassNotFoundException, SQLException {
	Class.forName("org.postgresql.Driver");
		
		Connection connect = DriverManager.getConnection(url);
		//getConnection is overloaded method
		
		String sql = "Select * from student";
		
		
		
		//String sql = "Insert into student values (25,'random','F','O+ve',984562)";
		//for insert, delete queries it will show exception for executeQuery method as the result set is not created for the query. 
		//but the query will run and the data will be changes inside the table of the database
		
		Statement stmt = connect.createStatement();
		//if taking hardcoded input, use statement
		
		
		boolean res = stmt.execute(sql);
		System.out.println(res);
		ResultSet rs = stmt.getResultSet(); //will only create object in select query
		System.out.println(rs);
		while(rs.next()) {
			int id = rs.getInt(1); //rs.getInt("id")
			String name = rs.getString(2); //rs.getString("name")
			String gender = rs.getString(3); //rs.getString("gender")
			
			System.out.println(id + " " + name + " " + gender);
			
		}
		
		//.execute will give output as boolean value
		//.executeQuery will give the entire output of the query
	}
}