package prac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD_Operations {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=tiger";
//		String u_name = "postgres";
//		String password = "tiger";
		try {
//			Connection connect = DriverManager.getConnection(url,u_name,password);
			Connection connect = DriverManager.getConnection(url);
			String sql = "select * from student";
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			connect.close();
			System.out.println("Success");
			while(rs.next()){
				int id = rs.getInt(1);// column name or index
				String name = rs.getString(2);
				double per = rs.getDouble(3);
				System.out.println(id+ " " + name+ " "+ per+" ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
