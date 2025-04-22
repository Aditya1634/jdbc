package prac;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school";
		String u_name = "postgres";
		String password = "tiger";
		
		try {
			DriverManager.getConnection(url, u_name, password);
			System.out.println("Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
